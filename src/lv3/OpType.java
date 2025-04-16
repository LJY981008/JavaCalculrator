package lv3;

public enum OpType {
    PLUS("+"), MINUS("-"), MULT("*"), DIV("/");

    private final char type;

    OpType(String type) {
        this.type = type.charAt(0);
    }

    public char getType() {
        return type;
    }
}
