#### Clausal
- Symbolic에 onRegister()메소드?
- String을 쪼개다가 Clausal Symbol을 만나면 새로운 Calculator를 생성하는 로직을 호출

#### Input
- Calculator = Operations + input
- input은 배열의 차수로 depth를 나타내는 value.
  subcalculator에 depth 채워 넣어 핸들링
- Calculator에 input을 요구하는 operand가 등록되면, 타게팅이 가능하도록 id로 식별하는 input 수신자 목록을 생성해 관리
- 체크 여부에 따라 on off할 수 있는 연산도 있으면 좋겠다.
- Input도 입력 받을 때 Calculator로 한번 처리해서 받으면 입력하기 편한가?


##### Translator.java
- Clausal 구현,
  - SubCalculrator 인수처리 구현,
  - Deque와 StringTokenizer 기반의 인터프렛
  - 삼항연산자 구현,
  - 세미콜론 구분자 없이 정규식으로 구현,
  - 인수 클래스화,

- SymbolProvider, SymbolMap 부분은 꼭 코드리뷰 받아서 개선안을 듣자
  - A : 데이터 플로우의 관리는 객체지향적이지만 SymbolProvider의 구현체를 파싱하는 부분은 여전히 다형성이 적용되지 않았다.
  - -> 인터페이스에 onRegister() 메소드 추가하고 첫 글자에서 enum을 찾는 것 말고는 전부 onRgister() 메소드에 맡길 것 