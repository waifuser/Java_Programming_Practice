package academy.waifuser.level01.basic;

import java.util.*;
import java.lang.*;

public class Divider {
    int dividend = 0;
    int divisor = 0;

    public void divide(){
        Scanner mySc = new Scanner(System.in);
        System.out.print("분자 입력 : ");
        dividend = mySc.nextInt();
        System.out.print("분모 입력 : ");
        divisor = mySc.nextInt();
        System.out.println("결과 : " + dividend / divisor);
    }

}
