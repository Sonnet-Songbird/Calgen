package org.songbird.calgen.domain.Calculator;

import java.util.ArrayList;

public class Express {
    private ArrayList<Operation> operations;

    public Express(String expression, ArrayList<Operation> operations) {
        this.operations = operations;
    }

    public ArrayList<Operation> getOperations() {
        ArrayList<Operation> clone = new ArrayList<>();
        for (Operation operation : operations) {
            clone.add(operation.getClone());
        }
        return clone;
    }
}
