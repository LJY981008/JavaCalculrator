package lv1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operator = "";
        int value1 = 0, value2 = 0;
        String result = "";
        String stopper = "";
        boolean runCalculator = true;

        do {
            try {
                System.out.print("입력1 : ");
                value1 = scanner.nextInt();
                System.out.print("입력2 : ");
                value2 = scanner.nextInt();
                System.out.print("연산 방법 : ");
                operator = scanner.next();
                result = switch (operator.charAt(0)) {
                    case '+' -> String.valueOf(value1 + value2);
                    case '-' -> String.valueOf(value1 - value2);
                    case '*' -> String.valueOf(value1 * value2);
                    case '/' -> String.valueOf((double) value1 / value2);
                    default -> "잘못된 연산자입니다.";
                };
                if (result.equals("Infinity")) result = "나눗셈에 0을 넣을 수 없습니다";
                System.out.println(result);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            System.out.println("더 진행하시겠습니까?(exit 입력 시 종료)");
            stopper = scanner.next();
            if (stopper.equalsIgnoreCase("exit")) runCalculator = false;
        } while (runCalculator);

    }
}