package org.songbird.calgen.domain.Calculator;

import java.util.function.BiFunction;

public enum Operator implements BiFunction<Subject, Operand, Subject> {
    ADD {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(s.getValue() + o.getValue());
        }
    },
    SUB {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(s.getValue() - o.getValue());
        }
    },
    MULTI {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(s.getValue() * o.getValue());
        }
    },
    DIVIDE {
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
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.pow(s.getValue(), o.getValue()));
        }
    },
    SQRT {
        @Override
        public Subject apply(Subject s, Operand o) {
            if (s.getValue() >= 0) {
                return new Subject(Math.sqrt(s.getValue()));
            } else {
                throw new ArithmeticException("음수의 제곱근은 정의되지 않습니다.");
            }
        }
    },
    LOG {
        @Override
        public Subject apply(Subject s, Operand o) {
            if (s.getValue() > 0 && o.getValue() > 0 && o.getValue() != 1) {
                return new Subject(Math.log(s.getValue()) / Math.log(o.getValue()));
            } else {
                throw new ArithmeticException("로그 연산이 정의되지 않습니다.");
            }
        }
    },
    ABS {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.abs(s.getValue()));
        }
    },
    FACT {
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
    SIN {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.sin(s.getValue()));
        }
    },
    COS {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.cos(s.getValue()));
        }
    },
    TAN {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.tan(s.getValue()));
        }
    },
    ROUND {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject((double) Math.round(s.getValue()));
        }
    },
    FLOOR {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.floor(s.getValue()));
        }
    },
    MAX {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.max(s.getValue(), o.getValue()));
        }
    },
    MIN {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(Math.min(s.getValue(), o.getValue()));
        }
    },
    IS {
        @Override
        public Subject apply(Subject s, Operand o) {
            return new Subject(o.getValue());
        }
    }
}
