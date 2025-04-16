package lv3;
import java.util.ArrayList;
import java.util.List;

public class Calculrator<T extends Number> {
    public static List<String> listResult = new ArrayList<>();
    T value1;
    T value2;
    Calculrator(T value1, T value2){
        this.value1 = value1;
        this.value2 = value2;
    }

    public String calculate(char op) {
        double result;

        if (op == OpType.PLUS.getType()) {
            result = value1.doubleValue() + value2.doubleValue();
        } else if (op == OpType.MINUS.getType()) {
            result = value1.doubleValue() - value2.doubleValue();
        } else if (op == OpType.MULT.getType()) {
            result = value1.doubleValue() * value2.doubleValue();
        } else if (op == OpType.DIV.getType()) {
            result = value1.doubleValue() / value2.doubleValue();
        } else {
            return "연산자를 잘못 입력했습니다.";
        }

        if (value1 instanceof Integer && value2 instanceof Integer) {
            return String.valueOf((int) result);
        }else {
            return String.valueOf(result);
        }
    }
}
