#### Clausal
- Symbolic에 onRegister()메소드?
- String을 쪼개다가 Clausal  Symbol을 만나면 새로운 Calculator를 생성하는 로직을 호출

#### Input
- Calculator = Operations + input
- input은 배열의 차수로 depth를 나타내는  value.
subcalculator에 depth 채워 넣어 핸들링
- Calculator에 input을 요구하는 operand가 등록되면, 타게팅이 가능하도록 id로 식별하는 input 수신자 목록을 생성해 관리 

- 체크 여부에 따라 on off할 수 있는 연산도 있으면 좋겠다.