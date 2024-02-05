//todo: mutable static 상수 Map<Charactor, SymbolProviider>를 만들어서, 각 클래스의 static 블록에서 여기에 regist하고,
//      가능한 클래스의 타입을 알아내지 않고 객체의 다형성만을 이용해서 작동하도록 해보자.
//      해당 클래스에 종속된 동작은 모두 해당 클래스의 책임으로.
package org.songbird.calgen.domain.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class SymbolMap {
    private static final Map<Character, Symbolic> symbolMap = new HashMap<>();

    private SymbolMap() {
    }

    public static void put(Character symbol, Symbolic symbolic) {
        symbolMap.put(symbol, symbolic);
    }


    public static Optional<Symbolic> get(Character character) {
        return Optional.ofNullable(symbolMap.get(character));
    }
}
