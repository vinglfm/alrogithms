package com.algorithms.parser;

import com.algorithms.Operation;

import java.util.Deque;

public final class Holder {
    private Deque<Integer> numbers;
    private Deque<Operation> operations;

    public Holder(Deque<Integer> numbers, Deque<Operation> operations) {
        this.numbers = numbers;
        this.operations = operations;
    }

    public Deque<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(Deque<Integer> numbers) {
        this.numbers = numbers;
    }

    public Deque<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Deque<Operation> operations) {
        this.operations = operations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Holder holder = (Holder) o;

        if (numbers != null ? !numbers.equals(holder.numbers) : holder.numbers != null) return false;
        return !(operations != null ? !operations.equals(holder.operations) : holder.operations != null);

    }

    @Override
    public int hashCode() {
        int result = numbers != null ? numbers.hashCode() : 0;
        result = 31 * result + (operations != null ? operations.hashCode() : 0);
        return result;
    }
}
