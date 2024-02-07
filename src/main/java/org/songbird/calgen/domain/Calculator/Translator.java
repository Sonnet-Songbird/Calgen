package org.songbird.calgen.domain.Calculator;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

class Translator {


    public static Deque<Character> dequeOf(String sourceCode) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < sourceCode.length(); i++) {
            deque.add(sourceCode.charAt(i));
        }

        return deque;
    }

    //Todo: (추후 개선사항) 가능하면 getBySymbol 부분의 메소드를 분리하고 싶음.
    public static Optional<Symbolic> decode(char code) {
        Optional<Symbolic> result = null;
//        result = Operator.getBySymbol(code);
//        if (result.isPresent()) {
//            return result;
//        }
//        result = OperandType.getBySymbol(code);
//        if (result.isPresent())
//            return result;
//
//        result = ClausalSymbol.getBySymbol(code);
//        // ClausalSymbol Solver
        return result;
    }
}


