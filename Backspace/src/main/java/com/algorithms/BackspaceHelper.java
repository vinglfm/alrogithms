package com.algorithms;

import com.algorithms.validation.PredicateValidator;
import com.algorithms.validation.Validator;
import com.sun.javaws.exceptions.InvalidArgumentException;

public class BackspaceHelper {

    private static final int ASCII_CHARACTER_BEGINING = '0';
    private static final int ASCII_LENGTH = 8;
    private static final int KANJI_CHARACTER_BEGINING = '1';
    private static final int KANJI_LENGTH = 16;

    private final Validator validator;

    public BackspaceHelper() {
        this.validator = new PredicateValidator();
    }

    public char[] backspace(char[] data, int index) {
        validator.validate(elem -> elem == null, data, "data shouldn't be null.");
        validator.validate(elem -> elem.length < 8, data, "data should be more then 8 bit.");
        validator.validate(deletedIndex -> deletedIndex < 8 || deletedIndex >= data.length,
                index, "Index should be between 8 and " + data.length);

        int oneByteBeforeIndex = index - 8;
        int twoByteBeforeIndex = index - 16;

        if (isAscii(data[oneByteBeforeIndex])) {
            if (oneByteBeforeIndex == 0 || isAscii(data[twoByteBeforeIndex])) {
                return delete(data, oneByteBeforeIndex, ASCII_LENGTH);
            } else if (isKanji(data[twoByteBeforeIndex])) {
                return delete(data, twoByteBeforeIndex, KANJI_LENGTH);
            } else {
                throw new IllegalArgumentException("data is not well formatted.");
            }
        } else if (isKanji(data[oneByteBeforeIndex])) {
            return delete(data, twoByteBeforeIndex, KANJI_LENGTH);
        } else {
            throw new IllegalArgumentException("data is not well formatted.");
        }
    }

    private boolean isKanji(char bit) {
        return bit == KANJI_CHARACTER_BEGINING;
    }

    private boolean isAscii(char bit) {
        return bit == ASCII_CHARACTER_BEGINING;
    }

    private char[] delete(char[] fromArray, int start, int length) {
        char[] toArray = new char[fromArray.length - length];
        System.arraycopy(fromArray, 0, toArray, 0, start == 0 ? 0 : start - 1);
        System.arraycopy(fromArray, start + length, toArray, start, toArray.length - start);
        return toArray;
    }
}
