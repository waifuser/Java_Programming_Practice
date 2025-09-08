package academy.waifuser.section01.conditional.level03.hard;

import java.util.Objects;
import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /* 과일 이름("사과", "바나나", "복숭아", "키위") 중 한 가지를 문자열로 입력하면
         * 해당하는 가격에 맞게 상품명과 가격이 출력되게 하세요.
         * 단, 목록에 없는 과일을 입력 시 "준비된 상품이 없습니다." 출력 후 프로그램 종료
         *
         * -- 상품 가격 --
         * 사과 :  1000원
         * 바나나 : 3000원
         * 복숭아 : 2000원
         * 키위 : 5000원
         *
         * -- 입력 예시 --
         * 과일 이름을 입력하세요 : 바나나
         *
         * -- 출력 예시 --
         * 바나나의 가격은 3000원 입니다.
         * */

        /* 과일 클래스 생성 */
       class Fruit {
            String korName = "";
            int price;

            Fruit(String name, int price) {
                this.korName = name;
                this.price = price;
            }
        }

        /* 과일 판매가 및 이름 설정 */
        Fruit apple = new Fruit("사과", 1000);
        Fruit banana = new Fruit("바나나", 3000);
        Fruit peach = new Fruit("복숭아", 2000);
        Fruit kiwi = new Fruit("키위", 5000);

        Scanner scAnything = new Scanner(System.in);
        System.out.print("과일 이름을 입력하세요 : ");
        String name = scAnything.nextLine();
        Fruit selectedFruit;

        if (Objects.equals(name, apple.korName)) {
            selectedFruit = apple;
        } else if (Objects.equals(name, banana.korName)) {
            selectedFruit = banana;
        } else if (Objects.equals(name, peach.korName)) {
            selectedFruit = peach;
        } else if (Objects.equals(name, kiwi.korName)) {
            selectedFruit = kiwi;
        } else {
            System.out.println("준비된 상품이 없습니다.");
            return;
        }
        System.out.println(selectedFruit.korName + "의 가격은 " + selectedFruit.price + "원 입니다.");
    }
}
