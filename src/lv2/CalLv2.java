package lv2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalLv2 {
    public static void main(String[] args) {
        Calculrator calculrator = new Calculrator();
        Scanner scanner = new Scanner(System.in);
        int[] values = new int[2];
        String operator = "";
        String result = "";

        boolean runCalculrator = true;

        while (runCalculrator) {
            String stopper = "";
            try {
                System.out.print("입력1 : ");
                values[0] = scanner.nextInt();
                System.out.print("입력2 : ");
                values[1] = scanner.nextInt();
                System.out.print("연산 방법 : ");
                operator = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                break;
            }
            result = calculrator.calculate(values, operator.charAt(0));
            System.out.println("연산 결과 : " + result);
            System.out.println("연산을 계속 진행하시겠습니까?(종료 = exit)");
            stopper = scanner.next();
            if(stopper.equalsIgnoreCase("exit")) runCalculrator = false;
        }
        System.out.println("프로그램을 종료합니다.");

    }
}
