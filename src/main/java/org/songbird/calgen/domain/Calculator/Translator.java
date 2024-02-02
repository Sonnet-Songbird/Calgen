package org.songbird.calgen.domain.Calculator;

class Translator {

    public static Operations decode(String sourceCode) {
        int pointer = 0;
        Operations operations = Operations.init();

        return operations;
    }



/*
todo:코드 체크 정규식이 아니라 포인터와 인터프리터식으로 구현
    operation은 2개 이상의 char 해석을 통해 구성되므로 빌더 클래스 필요.
    무상태성 메소드들만 Translator에 보유시킬 것. 해석 책임은 순수 함수로 여기에 구현
    상태성을 지니는 Builder 클래스를 만들어 Translator 클래스를 호출해서 작동하도록 할 것. (in String to Operations)

todo:SubCalculrator 구현,
    SubCalculrator 인수처리 구현,
    Deque와 StringTokenizer 기반의 인터프렛
    삼항연산자 구현,
    세미콜론 구분자 없이 정규식으로 구현,
    인수 클래스화,

todo:SymbolProvider, SymbolMap 부분은 꼭 코드리뷰 받아서 개선안을 듣자
 */
}


