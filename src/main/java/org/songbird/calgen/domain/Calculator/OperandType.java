package org.songbird.calgen.domain.Calculator;

enum OperandType implements SymbolProvider {
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

    public abstract Operand create(double value);
}

