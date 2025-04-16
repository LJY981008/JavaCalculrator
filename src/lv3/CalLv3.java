package lv3;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 메인 클래스
 */
public class CalLv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int arraySize = 2;
        String[] values = new String[arraySize];
        Double[] doubleValues = new Double[arraySize];
        Integer[] intValues = new Integer[arraySize];
        String operator = "";
        String result = "";

        boolean runCalculrator = true;

        while (runCalculrator) {
            String stopper = "";
            try {
                System.out.print("입력1 : ");
                values[0] = scanner.next();
                System.out.print("입력2 : ");
                values[1] = scanner.next();
                System.out.print("연산 방법 : ");
                operator = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("다시 입력해 주세요.");
                continue;
            }
            Calculrator<?> calculrator = null;
            if(checkFormet(values[0]).equals("String") || checkFormet(values[1]).equals("String")){
                System.out.println("숫자를 입력해 주세요");
            }else if(checkFormet(values[0]).equals("double") || checkFormet(values[1]).equals("double")){
                for(int i = 0; i < arraySize; i++){
                    doubleValues[i] = Double.parseDouble(values[i]);
                }
                calculrator = new Calculrator<>(doubleValues[0], doubleValues[1]);
            }else{
                for(int i = 0; i <arraySize; i++){
                    intValues[i] = Integer.parseInt(values[i]);
                }
                calculrator = new Calculrator<>(intValues[0], intValues[1]);
            }

            if(calculrator != null) calculrator.calculate(operator.charAt(0));


            System.out.println("연산을 계속 진행하시겠습니까?(이어하기 = 아무키 입력, 종료 = exit)");

            stopper = scanner.next();
            if(stopper.equalsIgnoreCase("exit")) runCalculrator = false;
        }
        System.out.println("프로그램을 종료합니다.");

    }

    /**
     * 입력값이 int인지 double인지 판별하는 메서드
     * @param value
     * @return
     */
    public static String checkFormet(String value){
        try {
            Integer.parseInt(value);
            return "int";
        }catch (NumberFormatException e){
            try {
                Double.parseDouble(value);
                return "double";
            }catch (NumberFormatException e2){
                return "String";
            }
        }
    }
}
