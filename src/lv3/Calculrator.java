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
        String result = "";

        if(op == OpType.PLUS.getType()){
           result = String.valueOf(value1.doubleValue() + value2.doubleValue());
        }else if(op == OpType.MINUS.getType()){
            result = String.valueOf(value1.doubleValue() - value2.doubleValue());
        }else if(op == OpType.MULT.getType()){
            result = String.valueOf(value1.doubleValue() * value2.doubleValue());
        }else if(op == OpType.DIV.getType()){
            result = String.valueOf(value1.doubleValue() / value2.doubleValue());
        }else{
            result = "연산자를 잘못입력했습니다.";
        }

        return result;
    }
}
