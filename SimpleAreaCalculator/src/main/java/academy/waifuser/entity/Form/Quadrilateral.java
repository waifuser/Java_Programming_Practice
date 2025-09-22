package academy.waifuser.entity.Form;

import academy.waifuser.entity.GeoPoint;
import academy.waifuser.entity.Point;
import academy.waifuser.entity.Shape;
import academy.waifuser.entity.TargetData;

import java.util.ArrayList;
import java.util.List;

public class Quadrilateral extends TargetData implements Shape {

    public Quadrilateral(String name, List<GeoPoint> geoCoordinates) {
        super(name, geoCoordinates);
        this.cartesianCoordinates = new ArrayList<>();
    }

    @Override
    public void showGeoPoint() {
        for (GeoPoint geoPoint : geoCoordinates) {
            System.out.println(geoPoint.toString());
        }
    }

    @Override
    public void convertToCartesian() {
        cartesianCoordinates.clear();  /* 이전 변환 결과 찌꺼기 제거 */
        /* 데카르트 좌표계로 변환
         * 절대 좌표 참고
         * 위도에 따른 타원체 x축 길이 변화 보정을 추가
         * 1도에 약 110여 km를 미터로 바꿔 변환 */
        for (GeoPoint gp : geoCoordinates) {
            double x = gp.getLongitude() * 111320 * Math.cos(Math.toRadians(gp.getLatitude()));
            double y = gp.getLatitude() * 110540;
            cartesianCoordinates.add(new Point(x, y));
        }
        /* 중심 기준 아크탄젠트값으로 정렬 위한 무게중심 계산 */
        double cx = cartesianCoordinates.stream().mapToDouble(Point::getX).average().orElse(0);
        double cy = cartesianCoordinates.stream().mapToDouble(Point::getY).average().orElse(0);

        /* 아크탄젠트 기준 시계방향 회전 정도로 점 정렬 */
        cartesianCoordinates.sort((p1, p2) -> {
            double angle1 = Math.atan2(p1.getY() - cy, p1.getX() - cx);
            double angle2 = Math.atan2(p2.getY() - cy, p2.getX() - cx);
            return Double.compare(angle2, angle1); /* 다음 원소가 더 큰 각도로 > 시계방향 */
        });
    }

    @Override
    public double calculateArea() {
        double area = 0.0;
        int n = cartesianCoordinates.size();
        /* 궁극 초필살기 프레드리히의 shoelace formula 이용하여
         * 좌표평면상 점들로 벡터곱 외적(면적 Cross Product) 계산 */
        for (int i = 0; i < n; i++) {
            Point p1 = cartesianCoordinates.get(i);
            Point p2 = cartesianCoordinates.get((i + 1) % n); /* 마지막 점은 첫 점과 연결 */
            area += (p1.getX() * p2.getY()) - (p2.getX() * p1.getY());
        }

        return Math.abs(area) / 2.0;
    }
}
