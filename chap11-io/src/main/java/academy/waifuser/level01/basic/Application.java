package academy.waifuser.level01.basic;

import java.io.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        /* ----- 입력 예시 -----
         *
         * (존재하는 파일명을 입력한 경우)
         * 파일 이름을 입력하세요 : hello.txt
         *
         * ----- 출력 예시 -----
         *
         * ===== 파일 내용 출력 =====
         * 안녕하세요. 반갑습니다. 제 이름은 홍길동입니다.
         *
         * ----- 입력 예시 -----
         *
         * (존재하지 않는 파일명을 입력한 경우)
         * 파일 이름을 입력하세요 : unknown.txt
         *
         * ----- 출력 예시 -----
         *
         * 오류 : 해당 이름을 가진 파일이 없습니다.
         *
         */

        BufferedReader myBr = null;
        String filePathAndName;
        Scanner mySc = new Scanner(System.in);
        try {
            System.out.print("파일 이름을 입력하세요 : ");
            filePathAndName = mySc.nextLine();
            myBr = new BufferedReader(new FileReader(filePathAndName));
            System.out.println("===== 파일 내용 출력 =====");
            String temp;
            while ((temp = myBr.readLine()) != null) {
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("오류 : 해당 이름을 가진 파일이 없습니다.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (myBr != null) {
                try {
                    myBr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

