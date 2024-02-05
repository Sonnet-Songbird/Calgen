package org.songbird.calgen.domain.Calculator;

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


    static {
        for (OperandType operandType : OperandType.values()) {
            SymbolMap.put(operandType.getSymbol(), operandType);
        }
    }

    public abstract Operand create(double value);

}

