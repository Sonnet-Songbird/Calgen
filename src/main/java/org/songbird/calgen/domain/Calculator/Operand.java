package org.songbird.calgen.domain.Calculator;

abstract class Operand {
    private final double value;

    Operand() {
        this.value = 0;
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

    public boolean isCalculator() {
        return false;
    }

    abstract Operand getClone();

}

class Constant extends Operand {

    public Constant(double value) {
        super(value);
    }

    @Override
    Constant getClone() {
        return new Constant(getValue());
    }


}

class Variable extends Operand {

    @Override
    public boolean isVariable() {
        return true;
    }

    @Override
    Variable getClone() {
        return new Variable();
    }

}


class Subject extends Operand {
    public Subject(double value) {
        super(value);
    }

    @Override
    Subject getClone() {
        return new Subject(getValue());
    }

    public Subject() {
        super();
    }
}

class SubCalculator extends Operand {
    private final Calculator calculator;

    public SubCalculator(Expression expression) {
        this.calculator = Calculator.create(expression);
    }

    public SubCalculator(Calculator original) {
        this.calculator = original;
    }

    @Override
    SubCalculator getClone() {
        return new SubCalculator(calculator);
    }

    @Override
    public double getValue() {
        return calculator.perform();
    }

    @Override
    public boolean isCalculator() {
        return true;
    }

    public Calculator getCalculator() {
        return calculator;
    }

}



