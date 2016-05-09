package com.algorithms;

import datastructures.GenericTrie;
import datastructures.SearchResult;
import datastructures.Trie;

import java.util.*;

public class RemoveHelper {

    private Trie wordsToRemove;

    public RemoveHelper() {
        wordsToRemove = new GenericTrie();
    }

    public void addProhibitedWords(String data) {
        if (data == null) {
            throw new IllegalArgumentException("prohibited string shouldn't be null.");
        }
        wordsToRemove.add(data.toCharArray());
    }

    public String remove(String data) {
        if (data == null) {
            throw new IllegalArgumentException("text to clean up shouldn't be null.");
        }

        char[] chars = data.toCharArray();
        int current = 0;
        int removedChars = 0;

        List<StringBuilder> words = new ArrayList<>();

        while (current < chars.length - removedChars) {
            words.add(new StringBuilder());

            int lengthToRemove = getLengthToRemove(words, chars[current]);

            if (lengthToRemove != 0) {
                words.clear();
                removedChars += lengthToRemove;
                shift(chars, current, removedChars, lengthToRemove);
            } else {
                ++current;
            }
        }

        return prepareResult(chars, removedChars);
    }

    private void shift(char[] chars, int current, int removedChars, int lengthToRemove) {
        if(current < chars.length - removedChars) {
            System.arraycopy(chars, current + 1, chars, current - lengthToRemove + 1, chars.length - removedChars - current);
        }
    }

    private String prepareResult(char[] chars, int removedChars) {
        return new StringBuilder().append(chars, 0, chars.length - removedChars).toString();
    }

    private int getLengthToRemove(List<StringBuilder> words, char current) {
        for (int i = 0; i < words.size(); ) {
            String word = words.get(i).append(current).toString();
            SearchResult searchResult = this.wordsToRemove.contains(word.toCharArray());
            if (searchResult.isWord()) {
                return word.length();
            } else if (!searchResult.isPresent()) {
                words.remove(i);
            } else {
                ++i;
            }
        }
        return 0;
    }
}
