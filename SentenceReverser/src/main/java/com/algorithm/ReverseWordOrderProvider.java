package com.algorithm;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.lang3.Validate.notNull;

public class ReverseWordOrderProvider {

    private static final String NULL_SENTENCE_MESSAGE = "sentence shouldn't be null.";

    private final Set<Character> delimiters;

    public ReverseWordOrderProvider(char... delimiters) {
        this.delimiters = new HashSet<>();
        for (Character delimiter : delimiters) {
            this.delimiters.add(delimiter);
        }
    }

    public char[] reverse(char[] sentence) {
        notNull(sentence, NULL_SENTENCE_MESSAGE);

        char[] reversedSentence = new char[sentence.length];

        int endPosition = sentence.length;
        int reversedPosition = 0;

        for (int i = endPosition - 1; i >= 0; --i) {
            if (isDelimiter(sentence[i])) {

                if(endPosition > i) {
                    reversedPosition = copyWord(sentence, reversedSentence, i + 1, endPosition, reversedPosition);
                }

                reversedSentence[reversedPosition++] = sentence[i];
                endPosition = i;
            }
        }

        copyWord(sentence, reversedSentence, 0, endPosition, reversedPosition);

        return reversedSentence;
    }

    private int copyWord(char[] fromArray, char[] toArray, int fromStart, int fromEnd, int toStart) {
        for (int j = fromStart; j < fromEnd; ++j) {
            toArray[toStart++] = fromArray[j];
        }
        return toStart;
    }

    private boolean isDelimiter(Character character) {
        return delimiters.contains(character);
    }
}
