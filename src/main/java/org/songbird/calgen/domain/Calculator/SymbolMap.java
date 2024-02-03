//todo: mutable static 상수 Map<Charactor, SymbolProviider>를 만들어서, 각 클래스의 static 블록에서 여기에 regist하고,
//      가능한 클래스의 타입을 알아내지 않고 객체의 다형성만을 이용해서 작동하도록 해보자.
//      해당 클래스에 종속된 동작은 모두 해당 클래스의 책임으로.
//package org.songbird.calgen.domain.Calculator;
//
//import java.util.HashMap;
//
//class SymbolMap {
//    private static SymbolMap instance;
//    private HashMap<Character, SymbolProvider> symbolMap;
//
//    private SymbolMap() {
//        this.symbolMap = mappingSymbol();
//
//    }
//
//    private HashMap<Character, SymbolProvider> mappingSymbol() {
//        HashMap<Character, SymbolProvider> map = new HashMap<>();
//
//        for (Operator operator : Operator.values()) {
//            map.put(operator.getSymbol(), operator);
//        }
//        for (OperandType operand : OperandType.values()) {
//            map.put(operand.getSymbol(), operand);
//        }
//        for (ClausalSymbol clausal : ClausalSymbol.values()) {
//            map.put(clausal.getSymbol(), clausal);
//        }
//        return map;
//    }
//
//    static SymbolMap getSymbolMap() {
//        if (instance == null)
//            instance = new SymbolMap();
//        return instance;
//    }
//
//    public SymbolProvider getEnumBySymbol(Character character) {
//        return symbolMap.get(character);
//    }
//}
