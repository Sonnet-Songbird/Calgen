package org.songbird.calgen.domain.Calculator;

import java.util.ArrayList;
import java.util.Deque;

public class Calculator {
    private final ArrayList<Operation> operations;

    private Calculator(Operations operations) {
        this.operations = operations.getOperations();
    }

    public static Calculator of(Deque<Character> deque) {
        Calculator calculator = new Calculator(Operations.of(deque));
        calculator.validate();
        return calculator;
    }


    //todo: 이런 거 안티 패턴인가?
    public static Calculator of(String string) {
        return of(Translator.dequeOf(string));
    }

    public Calculator setOperand(double[] input) throws IllegalArgumentException {
        int index = 0;
//        for (Operation operation : express.getOperations()) {
//            Operand operand = operation.getOperand();
//            if (operand.isCalculator()) {
//                double subCalcValue = operand.getValue();
//                operation.setOperand(new Constant(subCalcValue));
//            } else if (operand.isVariable()) {
//                if (index == input.length) {
//                    throw new IllegalArgumentException("입력 값의 길이가 필요한 변수의 개수보다 적습니다.");
//                }
//                operation.setOperand(new Constant(input[index]));
//                index++;
//            }
//        }
        if (index < input.length) {
            throw new IllegalArgumentException("입력 값의 길이가 필요한 변수의 개수보다 많습니다.");
        }
        return this;
    }

    Result perform() throws IllegalArgumentException {
        validate();
        Subject subject = new Subject();
        for (Operation operation : operations) {
            subject = operation.getOperator().apply(subject, operation.getOperand());
        }
        return subject.complete();
    }

    private void validate() throws IllegalArgumentException {
        if (operations.isEmpty()) {
            throw new IllegalArgumentException("perform 메소드 실행 중 예외 발생 : Operation이 없습니다.");
        }
        if (!operations.get(0).getOperator().equals(Operator.IS))
            throw new IllegalArgumentException("perform 메소드 실행 중 예외 발생 : 첫번째 Operator는 IS여야합니다.");
    }
}
