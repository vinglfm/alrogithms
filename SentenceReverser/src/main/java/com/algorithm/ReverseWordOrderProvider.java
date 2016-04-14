package com.algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static org.apache.commons.lang3.Validate.notNull;

public class ReverseWordOrderProvider {

    private static final String NULL_SENTENCE_MESSAGE = "sentence shouldn't be null.";

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

    private boolean isDelimiter(char character) {
        return character == ' ';
    }

    public static void main(String[] args) throws IOException {
        ReverseWordOrderProvider reverseWordOrderProvider = new ReverseWordOrderProvider();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a sentence to reverse: ");
        String sentence = bufferedReader.readLine();

        char[] reversedSentence = reverseWordOrderProvider.reverse(sentence.toCharArray());
        System.out.println("Reversed sentence: " + Arrays.toString(reversedSentence));
    }
}
