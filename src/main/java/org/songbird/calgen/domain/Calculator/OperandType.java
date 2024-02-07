package org.songbird.calgen.domain.Calculator;

import java.util.Deque;

enum OperandType implements Symbolic {
    CONSTANT {
        @Override
        public char getSymbol() {
            return '0';
        }

        @Override
        public Operand create(double value) {
            return new Constant(value);
        }

        @Override
        public void onRegister(Deque<Character> deque) {
            //todo: Implementation needed
        }
    },
    VARIABLE {
        @Override
        public char getSymbol() {
            return '@';
        }

        @Override
        public Operand create(double value) {
            return new Variable();
        }

        @Override
        public void onRegister(Deque<Character> deque) {
            //todo: Implementation needed
        }
    },
    SUBJECT {
        @Override
        public char getSymbol() {
            return '[';
        }

        @Override
        public Operand create(double value) {
            return new Subject(value);
        }

        @Override
        public void onRegister(Deque<Character> deque) {
            // empty implementation
        }
    };


    static {
        for (OperandType operandType : OperandType.values()) {
            SymbolMap.put(operandType.getSymbol(), operandType);
        }
    }

    public abstract Operand create(double value);

}

