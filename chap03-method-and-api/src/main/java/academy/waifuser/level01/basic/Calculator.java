package academy.waifuser.level01.basic;

public class Calculator {
    public void checkMethod(){
        System.out.println("메소드 호출 확인");
    }

    public int sum1to10(){
        int result = 0;
        for(int i=1; i <= 10 ; i++){
            result += i;
        }
        return result;
    }
    public void checkMaxNumber(int a, int b){
        int largerNumber = Math.max(a, b);
        System.out.println("두 수 중 큰 수는 " + largerNumber +"다");
    }

    public int sumTwoNumber(int a, int b){
        return a + b;
    }

    public int minusTwoNumber(int a, int b){
        int result = 0;
        result = a > b ? a - b : b - a;
        return result;
    }
}
