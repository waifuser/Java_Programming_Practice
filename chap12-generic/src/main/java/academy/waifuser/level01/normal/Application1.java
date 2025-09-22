package academy.waifuser.level01.normal;

import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("swap 전 : " + Arrays.toString(intArray));  // [1, 2, 3, 4, 5]
        swap(intArray, 1, 3);
        System.out.println("swap 후 : " + Arrays.toString(intArray));  // [1, 4, 3, 2, 5]

        String[] strArray = {"A", "B", "C", "D"};
        System.out.println("swap 전 : " + Arrays.toString(strArray));  // [A, B, C, D]
        swap(strArray, 0, 2);
        System.out.println("swap 후 : " + Arrays.toString(strArray));  // [C, B, A, D]
    }

    public static <T> void swap(T[] arrayName, int swapIndex1, int swapIndex2) {
        T temp;
        temp = arrayName[swapIndex1];
        arrayName[swapIndex1] = arrayName[swapIndex2];
        arrayName[swapIndex2] = temp;
    }
}
