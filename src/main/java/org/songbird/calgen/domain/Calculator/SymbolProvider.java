package org.songbird.calgen.domain.Calculator;

import java.util.HashMap;
import java.util.function.Function;

interface SymbolProvider {
    char getSymbol();
}

class SymbolMap {
    private static SymbolMap instance;
    static final HashMap<char,> SymbolMap;

    private SymbolMap() {
        this.Symbolmap
    }

    static SymbolMap getSymbolMap() {
        if (instance == null)
            instance = new SymbolMap();
        return instance;
    }

    static class Constructor implements Runnable {
        Function<> constructor;

        @Override
        public void run() {

        }
    }
}
