package lv1;

import java.util.Scanner;

public class CalLv1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operator;
        int value1, value2;
        String result;
        boolean runCalculator = true;

        do {
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
            System.out.println("더 진행하시겠습니까?(exit 입력 시 종료)");
            if (scanner.nextLine().equalsIgnoreCase("exit")) runCalculator = false;
        } while (runCalculator);

    }
}