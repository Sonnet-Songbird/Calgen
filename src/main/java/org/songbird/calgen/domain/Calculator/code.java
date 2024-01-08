package org.songbird.calgen.domain.Calculator;

import java.util.ArrayList;

public class code {
    public static Express decode(String expression) {
        ArrayList<Operation> operationList = decodeOperations(expression);
        return new Express(expression, operationList);
    }

    private static ArrayList<Operation> decodeOperations(String expression) {
        String[] opCodes = splitCode(expression);
        ArrayList<Operation> operationList = new ArrayList<Operation>();
        for (String opCode : opCodes) {
            operationList.add(decodeOperation(opCode));
        }
        return operationList;
    }

    private static String[] splitCode(String expression) {
        return expression.split(";");
    }

    private static Operation decodeOperation(String opCode) {
        Operator operator = decodeOperator(opCode.charAt(0));
        Operand operand = decodeOperand(opCode.substring(1));
        return new Operation(operator, operand);
    }

    private static Operator decodeOperator(char symbol) {
        return Operator.fromSymbol(symbol);
    }

    private static Operand decodeOperand(String value) {
        if (value.equals("?"))
            return new Variable();
        else
            return new Constant(Double.parseDouble(value));
    }

    private static String encode(Operation operation) {
        String result = "";
        result += operation.getOperator().getSymbol();
        result += operation.getOperand().getValue();
        result += ";";
        return result;
    }
}

//todo:SubCalculrator 구현,
// 삼항연산자 구현,
// 세미콜론 구분자 없이 정규식으로 구현,
// 인수 클래스화,
// SubCalculrator 인수처리 구현,


//todo:코드 체크 정규식이 아니라 포인터와 인터프리터식으로 구현