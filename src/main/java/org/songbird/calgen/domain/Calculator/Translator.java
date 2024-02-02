package org.songbird.calgen.domain.Calculator;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

class Translator {


    public static Deque<Character> dequeOf(String sourceCode) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < sourceCode.length(); i++) {
            deque.add(sourceCode.charAt(i));
        }

        return deque;
    }

    //Todo: (추후 개선사항) 가능하면 getBySymbol 부분의 메소드를 분리하고 싶음.
    public static Optional<SymbolProvider> decode(char code) {
        Optional<SymbolProvider> result;
        result = Operator.getBySymbol(code);
        if (result.isPresent()) {
            return result;
        }
        result = OperandType.getBySymbol(code);
        if (result.isPresent())
            return result;

        result = ClausalSymbol.getBySymbol(code);
        // ClausalSymbol Solver
        return result;
    }



/*
todo:코드 체크 정규식이 아니라 포인터와 인터프리터식으로 구현
    operation은 2개 이상의 char 해석을 통해 구성되므로 빌더 클래스 필요.
    무상태성 메소드들만 Translator에 보유시킬 것. 해석 책임은 순수 함수로 여기에 구현
    상태성을 지니는 Builder 클래스를 만들어 Translator 클래스를 호출해서 작동하도록 할 것. (in String

todo:SubCalculrator 구현,
    SubCalculrator 인수처리 구현,
    Deque와 StringTokenizer 기반의 인터프렛
    삼항연산자 구현,
    세미콜론 구분자 없이 정규식으로 구현,
    인수 클래스화,

todo:SymbolProvider, SymbolMap 부분은 꼭 코드리뷰 받아서 개선안을 듣자
 */
}


