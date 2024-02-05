package org.songbird.calgen.domain.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
    };

    private static final Map<Character, OperandType> symbolMap = new HashMap<>();

    static {
        for (OperandType operandType : OperandType.values()) {
            symbolMap.put(operandType.getSymbol(), operandType);
        }
    }
    public static Optional<Symbolic> getBySymbol(char symbol) {
        return Optional.ofNullable(symbolMap.get(symbol));
    }

    public abstract Operand create(double value);

}

