package org.songbird.calgen.domain.Calculator;

abstract class Operand {
    private double value;

    Operand() {
    }

    Operand(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public boolean isVariable() {
        return false;
    }


}

class Constant extends Operand {

    public Constant(double value) {
        super(value);
    }


}

class Variable extends Operand {
    public Variable() {
        super();
    }

    @Override
    public boolean isVariable() {
        return true;
    }

}


class Subject extends Operand {
    public Subject(double value) {
        super(value);
    }

    public Subject() {
        super();
    }
}
