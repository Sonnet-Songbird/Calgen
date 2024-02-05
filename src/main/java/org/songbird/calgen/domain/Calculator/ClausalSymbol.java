package org.songbird.calgen.domain.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum ClausalSymbol implements Symbolic {
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
    private static final Map<Character, ClausalSymbol> symbolMap = new HashMap<>();
    private static final Map<Character, ClausalSymbol> endSymbolMap = new HashMap<>();

    static {
        for (ClausalSymbol clausalSymbol : ClausalSymbol.values()) {
            symbolMap.put(clausalSymbol.getSymbol(), clausalSymbol);
        }
    }

    static {
        for (ClausalSymbol clausalSymbol : ClausalSymbol.values()) {
            symbolMap.put(clausalSymbol.getEndSymbol(), clausalSymbol);
        }
    }

    static Optional<Symbolic> getBySymbol(char symbol) {
        return Optional.ofNullable(symbolMap.get(symbol));
    }

    static Optional<Symbolic> getByEndSymbol(char symbol) {
        return Optional.ofNullable(symbolMap.get(symbol));
    }

    @Override
    public abstract char getSymbol();

    public abstract char getEndSymbol();
}
