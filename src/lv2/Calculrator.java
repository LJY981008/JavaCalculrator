package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculrator {
    Stack<String> listResult = new Stack<>();
    public String calculate(int[] values, char operator){
        String result = switch (operator){
            case '+' -> String.valueOf(values[0] + values[1]);
            case '-' -> String.valueOf(values[0] - values[1]);
            case '*' -> String.valueOf(values[0] * values[1]);
            case '/' -> String.valueOf((double) values[0] + values[1]);
            default -> "연산실패";
        };

        return result;
    }
}
