package datastructures;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    private final Map<Character, TrieNode> chars;
    private boolean end;

    TrieNode() {
        chars = new HashMap<>();
        end = false;
    }

    void put(Character elem) {
        if (!chars.containsKey(elem)) {
            chars.put(elem, new TrieNode());
        }
    }

    private TrieNode putCharacter(char elem) {
        TrieNode next = new TrieNode();
        chars.put(elem, next);
        return next;
    }

    TrieNode next(Character elem) {
        return chars.get(elem);
    }

    void setEnd() {
        end = true;
    }

    boolean isEnd() {
        return end;
    }
}
