package org.songbird.calgen.domain.Calculator;

interface Operand {
    double getValue();

    boolean isOperable();
}

class Subject implements Operand {
    private final double value;

    public Subject() {
        this.value = 0;
    }

    Subject(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean isOperable() {
        return false;
    }

    public Result complete() {
        return new Result(value);
    }
}

class Constant implements Operand {
    private final double value;

    Constant(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean isOperable() {
        return false;
    }
}

class Variable implements Operand {
    private Double value;
    private boolean isSet = false;

    public Variable() {
    }

    public void setValue(double value) {
        if (!isSet) {
            this.value = value;
            isSet = true;
        } else {
            throw new IllegalStateException("Variable의 값은 한 번만 할당 가능합니다.");
        }
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean isOperable() {
        return isSet;
    }
}

class Result implements Operand {
    public final double value;

    public Result(double value) {
        this.value = value;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public boolean isOperable() {
        return false;
    }
}

class SubResult extends Result {

    public SubResult(double value) {
        super(value);
    }

    @Override
    public boolean isOperable() {
        return true;
    }
}

class SubCalculator implements Operand {
    private final Calculator calculator;

    public SubCalculator(Expression expression) {
        this.calculator = Calculator.create(expression);
    }

    public SubCalculator(Calculator original) {
        this.calculator = original;
    }

    @Override
    public double getValue() {
        SubResult result = (SubResult) calculator.perform();
        return result.getValue();
    }

    @Override
    public boolean isOperable() {
        return false;
    }

    public Calculator getCalculator() {
        return calculator;
    }
}
