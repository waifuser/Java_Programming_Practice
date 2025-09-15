package academy.waifuser.level01.basic.student.run;

import academy.waifuser.level01.basic.student.model.dto.StudentDTO;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        StudentDTO[] studentArray = new StudentDTO[10];
        Scanner scAnything = new Scanner(System.in);
        char additionalToggle = 'y';
        int i = 0;
        do {
            if ((additionalToggle == 'n') || (i > 9)) {
                break;
            } else if ((additionalToggle == 'y') || (additionalToggle == 'Y')) {
                continue;
            }
        } while (true);
        scAnything.hashCode()
    }
}
