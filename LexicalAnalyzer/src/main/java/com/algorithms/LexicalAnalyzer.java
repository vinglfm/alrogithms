package com.algorithms;

import com.algorithms.parser.ArithmeticExpressionParser;
import com.algorithms.parser.Holder;

import java.util.*;

import static com.algorithms.Operation.*;

public class LexicalAnalyzer {

    private ArithmeticExpressionParser parser = new ArithmeticExpressionParser();


    public int evaluate(String expression) {

        Holder holder = parser.parse(expression);

        Deque<Operation> processingOperations = new ArrayDeque<>();
        Deque<Integer> processingNumbers = new ArrayDeque<>();

        processingNumbers.push(holder.getNumbers().removeFirst());

        if (!holder.getOperations().isEmpty()) {
            processingOperations.push(holder.getOperations().removeFirst());

            while (!processingOperations.isEmpty()) {
                Operation currentOperation = processingOperations.pop();
                if ((!holder.getOperations().isEmpty() && (ADDITION.equals(currentOperation) ||
                        SUBTRACTION.equals(currentOperation) ||
                        OPEN_BRACKET.equals(holder.getOperations().getFirst())))) {
                    processingOperations.push(currentOperation);
                    if (!holder.getOperations().isEmpty()) {
                        processingNumbers.push(holder.getNumbers().removeFirst());
                    }
                } else if (OPEN_BRACKET.equals(currentOperation)) {
                    processingOperations.push(currentOperation);
                } else {
                    if (!holder.getNumbers().isEmpty() && !CLOSED_BRACKET.equals(currentOperation)) {
                        processingNumbers.push(holder.getNumbers().removeFirst());
                    }
                    currentOperation.evaluate(processingNumbers, processingOperations);
                }

                if (!holder.getOperations().isEmpty()) {
                    processingOperations.push(holder.getOperations().removeFirst());
                }
            }
        }

        validateExpressionFormat(processingNumbers);

        return processingNumbers.pop();
    }

    private void validateExpressionFormat(Deque<Integer> processingNumbers) {
        if (processingNumbers.size() != 1) {
            throw new IllegalArgumentException("Expression can't be processed due to non arichmetic format.");
        }
    }
}
