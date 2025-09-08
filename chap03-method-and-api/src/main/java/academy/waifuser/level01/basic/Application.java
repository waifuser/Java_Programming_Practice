package academy.waifuser.level01.basic;

public class Application {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        //메소드 호출 확인용 메소드 호출
        calc.checkMethod();
        //함수를 호출하여 1~10까지의 합을 리턴 받아 출력
        System.out.println("1부터 10까지의 합 : " + calc.sum1to10());
        //10, 20 두 개의 정수를 매개변수로 하여 큰 값 출력하는 메소드 호출
        int x = 10;
        int y = 20;
        int z = 5;
        calc.checkMaxNumber(x, y);
        //10, 20 두 개의 정수를 매개변수로 하여 두 수를 더하는 메소드 호출 후 리턴값 출력
        System.out.println(x + "과 " + y + "의 합은 : " + calc.sumTwoNumber(x, y));
        //10, 5 두 개의 정수를 매개변수로 하여 두 수의 차를 구하는 메소드 호출 후 리턴값 출력
        System.out.println(x + "과 " + z + "의 차는 : " + calc.minusTwoNumber(x, z));
    }
}
