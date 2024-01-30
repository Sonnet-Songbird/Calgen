package org.songbird.calgen.domain.Calculator;
import java.util.ArrayList;

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
    public Subject operate(Subject subject) {
        return operator.apply(subject, operand);
    }
}


class Operations {
    ArrayList<Operation> operations;

    private Operations() {
    }

    static Operations init() {
        return new Operations();
    }

    void add(Operation operation) {
        operations.add(operation);
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }
}