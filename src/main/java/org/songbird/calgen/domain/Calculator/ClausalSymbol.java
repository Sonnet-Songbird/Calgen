package org.songbird.calgen.domain.Calculator;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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

        @Override
        public void onRegister(Deque<Character> deque) {
            //todo: Implementation needed

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

        @Override
        public void onRegister(Deque<Character> deque) {
            //todo: Implementation needed
        }
    };
    private static final Map<Character, ClausalSymbol> endSymbolMap = new HashMap<>();

    static {
        for (ClausalSymbol clausalSymbol : ClausalSymbol.values()) {
            SymbolMap.put(clausalSymbol.getSymbol(), clausalSymbol);
        }
    }


    //todo: endSymbol 구분해서 구현. 아마도 이건 이 클래스 내에서 처리 해야 할 것.
    static {
        for (ClausalSymbol clausalSymbol : ClausalSymbol.values()) {
            endSymbolMap.put(clausalSymbol.getEndSymbol(), clausalSymbol);
        }
    }

    @Override
    public abstract char getSymbol();


    public abstract char getEndSymbol();



}
