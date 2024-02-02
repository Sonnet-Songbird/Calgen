package org.songbird.calgen.domain.Calculator;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Optional;

class Operation {
    private final Operator operator;
    private Operand operand;


    private Operation(Operator operator, Operand operand) {
        this.operator = operator;
        this.operand = operand;
    }


    public static Operation pop(Deque<Character> deque) {
        Operator operator = null;
        Operand operand = null;
        boolean end = false;
        while (!end) {
            char code = deque.pop();
            Optional<SymbolProvider> optionalResult = Translator.decode(code);
            if (optionalResult.isEmpty())
                throw new IllegalArgumentException("코드에 잘못된 문자가 포함 되어 있습니다. : " + code);
            SymbolProvider result = optionalResult.get();
            if (result instanceof Operator && operator == null)
                operator = (Operator) result;
            else if (result instanceof Operand && operand == null)
                operand = (Operand) result;
            else throw new IllegalStateException("디코딩 중 예상치 못한 오류가 발생 했습니다. : " + code);

            if (operator != null && operand != null) {
                end = true;
            }
        }
        return new Operation(operator, operand);
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


    void add(Operation operation) {
        operations.add(operation);
    }

    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public static Operations of(String string) {
        Operations operations = new Operations();
        Deque<Character> deque = Translator.dequeOf(string);
        while (deque.peekFirst() != null) {
            operations.add(Operation.pop(deque));
        }
        return operations;
    }

}