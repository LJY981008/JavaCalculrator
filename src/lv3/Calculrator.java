package lv3;
import java.util.ArrayList;
import java.util.List;

import java.util.*;

public class Calculrator {
    List<String> listResult = new ArrayList<>();
    public String calculate(String[] values, char op) {

        if(op == OpType.PLUS.getType()){
            System.out.println("+");
        }else if(op == OpType.MINUS.getType()){
            System.out.println("-");
        }else if(op == OpType.MULT.getType()){
            System.out.println("*");
        }else if(op == OpType.DIV.getType()){
            System.out.println("/");
        }else{
            System.out.println("+4");
        }

        return " ";
    }
}
