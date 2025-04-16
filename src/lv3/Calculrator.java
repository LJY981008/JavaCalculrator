package lv3;

import java.util.*;

public class Calculrator {
    private Queue<String> queueResult = new LinkedList<>();
    public String calculate(double[] values, String operator){
        double result = OpType.findType(operator).cal(values);
        setQueueResult(String.valueOf(result));
        return String.valueOf(result);
    }

    public Queue<String> getQueueResult() {
        if(queueResult.isEmpty()) return null;
        return queueResult;
    }

    public void setQueueResult(String result){
        try {
            Double.parseDouble(result);
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
