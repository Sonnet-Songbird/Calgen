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
