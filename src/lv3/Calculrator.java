package lv3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Calculrator<T extends Number> {
    public static List<String> listResult = new ArrayList<>();
    T value1;
    T value2;
    Calculrator(T value1, T value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public void calculate(char op) {
        double result;
        boolean opTypeMissFlag = false;

        if (op == OpType.PLUS.getType()) {
            result = value1.doubleValue() + value2.doubleValue();
        } else if (op == OpType.MINUS.getType()) {
            result = value1.doubleValue() - value2.doubleValue();
        } else if (op == OpType.MULT.getType()) {
            result = value1.doubleValue() * value2.doubleValue();
        } else if (op == OpType.DIV.getType()) {
            result = value1.doubleValue() / value2.doubleValue();
        } else {
            opTypeMissFlag = true;
            result = Double.MAX_VALUE;
        }

        List<Double> biggers = (List<Double>) listResult.stream()
                .filter(num -> Double.parseDouble(num) > result)
                .map(Double::parseDouble)
                .toList();

        String stringResult;
        if(opTypeMissFlag){
            stringResult = "잘못된 연산자 입니다";
        }
        else if (value1 instanceof Integer && value2 instanceof Integer) {
            stringResult = String.valueOf((int)result);
            listResult.add(stringResult);

        }else {
            stringResult = String.valueOf(result);
            listResult.add(stringResult);
        }

        System.out.println("실행 결과 : " + stringResult);
        for(double bigger:biggers){
            System.out.print("결과 값보다 큰 이전 기록 : " );
            System.out.print(bigger + " ");
        }
        System.out.println();
    }
}
