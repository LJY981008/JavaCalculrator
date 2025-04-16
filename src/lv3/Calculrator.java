package lv3;

import java.util.*;
enum OpType{
    PLUS('+'),MINUS('-'),MULT('*'),DIV('/');
    final private char type;
    public char getType(){
        return type;
    }
    OpType(char type) {
        this.type = type;
    }
}

public class Calculrator {
    private Queue<String> queueResult = new LinkedList<>();
    public String calculate(int[] values, char operator){
        String result = switch (operator){
            case '+' -> String.valueOf(values[0] + values[1]);
            case '-' -> String.valueOf(values[0] - values[1]);
            case '*' -> String.valueOf(values[0] * values[1]);
            case '/' -> String.valueOf((double) values[0] + values[1]);
            default -> "연산실패";
        };
        setQueueResult(result);
        return result;
    }

    public Queue<String> getQueueResult() {
        if(queueResult.isEmpty()) return null;
        return queueResult;
    }

    public void setQueueResult(String result){
        try {
            Integer.parseInt(result);
            this.queueResult.offer(result);
        }catch (NumberFormatException e){
            System.out.println("결과가 정수가 아닙니다.");
        }
    }

    public void removeResult(){
        if(queueResult.isEmpty()) return;
        queueResult.poll();
    }
}
