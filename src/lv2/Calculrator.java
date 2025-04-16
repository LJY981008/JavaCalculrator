package lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Calculrator {
    private Stack<String> stackResult = new Stack<>();
    public String calculate(int[] values, char operator){
        String result = switch (operator){
            case '+' -> String.valueOf(values[0] + values[1]);
            case '-' -> String.valueOf(values[0] - values[1]);
            case '*' -> String.valueOf(values[0] * values[1]);
            case '/' -> String.valueOf((double) values[0] + values[1]);
            default -> "연산실패";
        };
        setStackResult(result);
        return result;
    }

    public String getStackResult() {
        if(stackResult.isEmpty()) return "연산기록이 없습니다.";
        return stackResult.pop();
    }

    public void setStackResult(String result){
        try {
            Integer.parseInt(result);
            this.stackResult.push(result);
        }catch (NumberFormatException e){
            System.out.println("결과가 정수가 아닙니다.");
        }
    }
}
