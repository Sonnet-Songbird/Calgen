package org.songbird.calgen.domain.Calculator;
import java.util.Deque;

interface Symbolic {
    char getSymbol();

    void onRegister(Deque<Character> deque);
}


