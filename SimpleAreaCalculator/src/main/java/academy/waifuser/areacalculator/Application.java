package academy.waifuser.areacalculator;

import academy.waifuser.areacalculator.exception.InvalidPointSizeException;
import academy.waifuser.areacalculator.exception.OutOfKoreaBoundsException;
import academy.waifuser.entity.Form.Pentagon;
import academy.waifuser.entity.Form.Quadrilateral;
import academy.waifuser.entity.Form.Triangle;
import academy.waifuser.entity.GeoPoint;
import academy.waifuser.entity.Shape;
import academy.waifuser.entity.TargetData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 실행 및 UI */
public class Application {
    private final Scanner sc;

    public Application() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("\n===방구석 임장 계산기===");
            System.out.println("1. 신규 데이터 입력 및 저장");
            System.out.println("2. 데이터 로드(미구현)");
            System.out.println("3. 데이터 삭제(미구현)");
            System.out.println("9. 프로그램 종료");
            System.out.print("메뉴 선택 : ");

            int menu = sc.nextInt();
            sc.nextLine();

            try {
                switch (menu) {
                    case 1 -> insertData();
                    case 2 -> loadData();
                    case 3 -> deleteData();
                    case 9 -> {
                        System.out.println("프로그램을 종료합니다.");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (InvalidPointSizeException e) {
                System.out.println("좌표 개수 오류입니다 : " + e.getMessage());
            } catch (OutOfKoreaBoundsException e) {
                System.out.println("좌표 범위 오류입니다 : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 오류 확인 바람 : " + e.getMessage());
            }
        }
    }

    private void insertData() {
        System.out.print("구역 이름을 입력하세요: ");
        String name = sc.nextLine();

        List<GeoPoint> points = new ArrayList<>();
        int pointIndex = 1;

        while (true) {
            System.out.println("\n--- " + pointIndex + "번째 점 입력 ---");

            /* 위도 입력 */
            if (pointIndex >= 4) {
                System.out.print("위도 입력 (예: 37.566535) 또는 'exit' 입력 : ");
            } else {
                System.out.print("위도 입력 (예: 37.566535) : ");
            }
            String latInput = sc.nextLine();

            if (pointIndex >= 4 && latInput.equalsIgnoreCase("exit")) {
                break; /* 4번째 이후 종료 허용 */
            }

            /* 경도 입력 */
            if (pointIndex >= 4) {
                System.out.print("경도 입력 (예: 126.978029) 또는 'exit' 입력 : ");
            } else {
                System.out.print("경도 입력 (예: 126.978029) : ");
            }
            String lonInput = sc.nextLine();

            if (pointIndex >= 4 && lonInput.equalsIgnoreCase("exit")) {
                System.out.println(pointIndex + "번째 포인트는 무시됩니다.");
                break; /* 입력 종료 */
            }

            try {
                double lat = Double.parseDouble(latInput);
                double lon = Double.parseDouble(lonInput);

                /* 한국 범위로 한정 */
                if (lat < 33.0 || lat > 39.5 || lon < 124.0 || lon > 132.0) {
                    throw new OutOfKoreaBoundsException("(" + lat + ", " + lon + ") 은 대한민국 영역을 벗어났습니다."
                    );
                }

                points.add(new GeoPoint(lat, lon));
                pointIndex++;

                /* 최대 5개까지 입력 */
                if (pointIndex > 5) break;

            } catch (NumberFormatException e) {
                System.out.println("숫자 형식이 잘못되었습니다. 다시 입력하세요.");
            }
        }

        // 4. 도형 객체 생성
        TargetData data = null;
        switch (points.size()) {
            case 3 -> data = new Triangle(name, points);
            case 4 -> data = new Quadrilateral(name, points);
            case 5 -> data = new Pentagon(name, points);

            default -> throw new IllegalStateException("Unexpected value: " + points.size());
        }

        // 5. 면적 계산
        if (data != null) {
            data.convertToCartesian();
            double area = data.calculateArea();
            String n = data.getName();
            data.showGeoPoint();
            System.out.println("[" + n + "]의 면적 = " + area + " m^2");

        }
    }

    public void loadData() {
        System.out.println("시간이 없어서 구현모했습니다 ㅠㅠ");
    }

    public void deleteData() {
        System.out.println("시간이 없어서 구현모했습니다 ㅠㅠ");
    }

    public static void main(String[] args) {
        new Application().run();
    }
}
