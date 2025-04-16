package lv2;

import java.util.*;

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

    // getter 기록이 없으면 null 반환
    public Queue<String> getQueueResult() {
        if(queueResult.isEmpty()) return null;
        return queueResult;
    }

    // setter, 숫자가 아닐 경우 catch
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
