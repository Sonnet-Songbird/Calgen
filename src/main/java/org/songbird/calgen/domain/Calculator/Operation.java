package org.songbird.calgen.domain.Calculator;

class Operation {
    private final Operator operator;
    private Operand operand;

    public Operation(Operator operator, Operand operand) {
        this.operator = operator;
        this.operand = operand;
    }


    Operator getOperator() {
        return operator;
    }

    Operand getOperand() {
        return operand;
    }

    public void setOperand(Constant constant) {
        this.operand = constant;
    }
}

