package lv3;

public enum OpType{
    PLUS("+") {
        @Override
        public double cal(double[] values) {
            return values[0] + values[1];
        }
    },
    MINUS("-") {
        @Override
        public double cal(double[] values) {
            return values[0] - values[1];
        }
    },
    MULT("*") {
        @Override
        public double cal(double[] values) {
            return values[0] - values[1];
        }
    },
    DIV("/") {
        @Override
        public double cal(double[] values) {
            if(values[1] == 0) {
                System.out.println("0으로 나눌 수 없습니다");
                return 0;
            }
            return values[0] / values[1];
        }
    },
    DEFAULT("잘못된 연산자") {
        @Override
        public double cal(double[] values) {
            System.out.println("연산자가 잘못되었습니다");
            return 0;
        }
    };

    final private String type;
    public String getType(){
        return type;
    }
    OpType(String type) {
        this.type = type;
    }

    public abstract double cal(double[] values);
    public static OpType findType(String type){
        for(OpType op : OpType.values()){
            if(op.getType().equals(type)){
                return op;
            }
        }
        return DEFAULT;
    }
}
