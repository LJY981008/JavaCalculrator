package lv3;

import java.util.*;

/**
 * 메인 클래스
 */
public class CalLv3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculrator<Integer> calculratorInt = new Calculrator<>();
        Calculrator<Double> calculratorDouble = new Calculrator<>();

        int arraySize = 2;
        boolean runCalculrator = true;
        String operator;
        String stringResult = "";
        String inputFormat;

        String[] inputValues = new String[arraySize];
        Double[] doubleValues = new Double[arraySize];
        Integer[] intValues = new Integer[arraySize];


        while (runCalculrator) {
            // 입력
            String stopper = "";
            try {
                System.out.print("입력1 : ");
                inputValues[0] = scanner.next();
                System.out.print("입력2 : ");
                inputValues[1] = scanner.next();
                System.out.print("연산 방법 : ");
                operator = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다.");
                System.out.println("다시 입력해 주세요.");
                continue;
            }

            // 입력 값의 정상적인지 체크하고 자료형 체크하고 Calculrator 호출
            // String = 수가 아닐 경우, double = 실수일 경우, int = 정수일 경우
            inputFormat = checkFormat(inputValues);
            if (inputFormat.equals("double")) {
                for (int i = 0; i < arraySize; i++) {
                    doubleValues[i] = Double.parseDouble(inputValues[i]);
                }
                stringResult = calculratorDouble.calculate(doubleValues[0], doubleValues[1], operator.charAt(0));
                printResult(stringResult, calculratorDouble.getRecord());
            } else if (inputFormat.equals("int")) {
                for (int i = 0; i < arraySize; i++) {
                    intValues[i] = Integer.parseInt(inputValues[i]);
                }
                stringResult = calculratorInt.calculate(intValues[0], intValues[1], operator.charAt(0));
                printResult(stringResult, calculratorInt.getRecord());
            } else {
                System.out.println("숫자를 입력해 주세요");
            }

            System.out.println("연산을 계속 진행하시겠습니까?(이어하기 = 아무키 입력, 종료 = exit)");
            stopper = scanner.next();
            if (stopper.equalsIgnoreCase("exit")) runCalculrator = false;
        }
        System.out.println("프로그램을 종료합니다.");
    }

    /**
     * 결과 출력
     * @param result 연산 결과
     * @param recordResult 이전 연산 기록
     */
    public static void printResult(String result, List<String> recordResult) {
        System.out.println("연산 결과 : " + result);
        if (!result.equals("잘못된 연산자 입니다")) {
            // 과거 연산 기록에서 result보다 큰 값을 filter해서 저장
            List<Double> biggers = recordResult.stream().filter(num -> Double.parseDouble(num) > Double.parseDouble(result)).map(Double::parseDouble).toList();
            // 저장한 큰 값들 출력
            System.out.print("결과 값보다 큰 이전 기록 : ");
            for (Double bigger : biggers) {
                String temp = String.valueOf(bigger);
                if (temp.endsWith(".0")) System.out.print(temp.substring(0, temp.length() - 2) + " ");
                else System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    /**
     * 입력값이 정수, 실수, 문자인지 판별하는 메서드
     * @param values 입력값
     * @return 입력값의 타입
     */
    public static String checkFormat(String[] values) {
        String format = "String";
        for (String value : values) {
            try {
                Integer.parseInt(value);
                format = format.equals("String") ? "int" : "double";
            } catch (NumberFormatException e) {
                try {
                    Double.parseDouble(value);
                    format = "double";
                } catch (NumberFormatException e2) {
                    format = "String";
                    break;
                }
            }

        }
        return format;
    }

}
