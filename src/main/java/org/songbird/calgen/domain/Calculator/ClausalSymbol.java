package org.songbird.calgen.domain.Calculator;

public enum ClausalSymbol implements SymbolProvider {
    CONDITIONAL {
        @Override
        public char getSymbol() {
            return '?';
        }

        @Override
        public char getEndSymbol() {
            return ';';
        }
    },
    SUBCALC {
        @Override
        public char getSymbol() {
            return '(';
        }

        @Override
        public char getEndSymbol() {
            return ')';
        }
    };

    @Override
    public abstract char getSymbol();

    public abstract char getEndSymbol();
}
