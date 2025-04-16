package lv3;

import java.util.ArrayList;
import java.util.List;

/**
 * 연산 클래스
 * @param <T> 연산의 필요한 값의 제너릭
 */
public class Calculrator<T extends Number> {
    public static List<String> listResult = new ArrayList<>();
    T value1;
    T value2;

    Calculrator(T value1, T value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    /**
     * 연산 메서드
     * @param op 연산기호
     */
    public String calculate(char op) {
        double result;
        String stringResult;

        // enum 열거형을 통해 연산자 체크
        if (op == OpType.PLUS.getType()) {
            result = value1.doubleValue() + value2.doubleValue();
        } else if (op == OpType.MINUS.getType()) {
            result = value1.doubleValue() - value2.doubleValue();
        } else if (op == OpType.MULT.getType()) {
            result = value1.doubleValue() * value2.doubleValue();
        } else if (op == OpType.DIV.getType()) {
            result = value1.doubleValue() / value2.doubleValue();
        } else {
            stringResult = "잘못된 연산자 입니다";
            return stringResult;
        }

        // 객체의 타입 확인해서 출력 결과에 적용
        if (value1 instanceof Integer && value2 instanceof Integer) {
            stringResult = String.valueOf((int) result);
            listResult.add(stringResult);

        } else {
            stringResult = String.valueOf(result);
            listResult.add(stringResult);
        }
        return stringResult;
    }
}
