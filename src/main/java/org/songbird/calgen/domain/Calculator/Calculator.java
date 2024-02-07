package org.songbird.calgen.domain.Calculator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Calculator {
    private final ArrayList<Operation> operations;
    private final InputReceiverManager receiverManager;


    private Calculator(Operations operations) {
        this.operations = operations.getOperations();
        this.receiverManager = new InputReceiverManager();
    }

    public static Calculator of(Deque<Character> deque) {
        Calculator calculator = new Calculator(Operations.of(deque));
        calculator.validate();
        calculator.receiverManager.init(calculator);
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


    static class InputReceiverManager {
        private final InputReceivers inputReceivers = new InputReceivers();

        private InputReceiverManager() {
        }

        public void init(Calculator calculator) {
            InputReceiverManager result = new InputReceiverManager();
            extract(calculator);
        }

        private void extract(Calculator calculator) {
            //todo: implementation needed
        }
    }

    static class InputReceivers {
        private final List<InputReceiver> inputReceivers = new ArrayList<>();

        Deque<InputReceiver> getDeque() {
            return new ArrayDeque<>(inputReceivers);
        }
    }

    static class InputReceiver {
        int id;
        Variable receiver;

        @Override
        public String toString() {
            return "InputReceiver{" +
                    "id=" + id +
                    ", receiver=" + receiver +
                    '}';
        }
    }



}
