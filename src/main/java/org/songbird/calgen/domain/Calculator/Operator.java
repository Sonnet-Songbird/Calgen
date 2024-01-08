// symbol ? = variable

package org.songbird.calgen.domain.Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator implements BiFunction<Subject, Operand, Subject> {
    IS {
        @Override
        char getSymbol() {
            return '=';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(o.getValue());
        }
    },
    ADD {
        @Override
        char getSymbol() {
            return '+';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(s.getValue() + o.getValue());
        }
    },
    SUB {
        @Override
        char getSymbol() {
            return '-';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(s.getValue() - o.getValue());
        }
    },
    MULTI {
        @Override
        char getSymbol() {
            return '*';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(s.getValue() * o.getValue());
        }
    },
    DIVIDE {
        @Override
        char getSymbol() {
            return '/';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            if (o.getValue() != 0) {
                return new Subject(s.getValue() / o.getValue());
            } else {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
        }
    },
    MODULO {
        @Override
        char getSymbol() {
            return '%';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            if (o.getValue() != 0) {
                return new Subject(s.getValue() % o.getValue());
            } else {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
        }
    },
    POWER {
        @Override
        char getSymbol() {
            return '^';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.pow(s.getValue(), o.getValue()));
        }
    },
    SQRT {
        @Override
        char getSymbol() {
            return '√';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            if (s.getValue() >= 0) {
                return new Subject(Math.sqrt(s.getValue()));
            } else {
                throw new ArithmeticException("음수의 제곱근은 정의되지 않습니다.");
            }
        }
    },
    FACT {
        @Override
        char getSymbol() {
            return '!';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            if (s.getValue() >= 0 && s.getValue() == Math.floor(s.getValue())) {
                int result = 1;
                for (int i = 1; i <= s.getValue(); i++) {
                    result *= i;
                }
                return new Subject(result);
            } else {
                throw new ArithmeticException("자연수 이외의 팩토리얼은 정의 되지 않습니다.");
            }
        }
    },
    ABS {
        @Override
        char getSymbol() {
            return 'a';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.abs(s.getValue()));
        }
    },
    LOG {
        @Override
        char getSymbol() {
            return 'l';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            if (s.getValue() > 0 && o.getValue() > 0 && o.getValue() != 1) {
                return new Subject(Math.log(s.getValue()) / Math.log(o.getValue()));
            } else {
                throw new ArithmeticException("로그 연산이 정의되지 않습니다.");
            }
        }
    },
    SIN {
        @Override
        char getSymbol() {
            return 's';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.sin(s.getValue()));
        }
    },
    COS {
        @Override
        char getSymbol() {
            return 'c';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.cos(s.getValue()));
        }
    },
    TAN {
        @Override
        char getSymbol() {
            return 't';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.tan(s.getValue()));
        }
    },
    ROUND {
        @Override
        char getSymbol() {
            return 'r';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject((double) Math.round(s.getValue()));
        }
    },
    FLOOR {
        @Override
        char getSymbol() {
            return 'f';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.floor(s.getValue()));
        }
    },
    MAX {
        @Override
        char getSymbol() {
            return 'M';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.max(s.getValue(), o.getValue()));
        }
    },
    MIN {
        @Override
        char getSymbol() {
            return 'm';
        }

        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.min(s.getValue(), o.getValue()));
        }
    },
    ;

    abstract char getSymbol();

    private static final Map<Character, Operator> symbolMap = new HashMap<>();

    static {
        for (Operator operator : values()) {
            symbolMap.put(operator.getSymbol(), operator);
        }
    }

    public boolean equals(String string) {
        return this.getSymbol().equals(string);
    }

    public static Operator fromSymbol(char symbol) {
        return symbolMap.get(symbol);
    }

}
