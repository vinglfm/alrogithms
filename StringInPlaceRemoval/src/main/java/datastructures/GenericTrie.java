package datastructures;

public class GenericTrie implements Trie {

    private final TrieNode root;

    public GenericTrie() {
        root = new TrieNode();
    }

    @Override
    public void add(char... data) {
        if (data == null) {
            throw new IllegalArgumentException("data can't be null.");
        }

        TrieNode current = root;
        TrieNode endNode = current;
        for (int i = 0; i < data.length; ++i) {
            char elem = data[i];
            TrieNode next = current.next(elem);
            if (next == null) {
                current.put(elem);
                next = current.next(elem);
            }
            endNode = current;
            current = next;
        }
        endNode.setEnd();
    }

    public SearchResult contains(char... data) {
        if (data == null) {
            throw new IllegalArgumentException("data can't be null.");
        }

        if (data.length == 0) {
            return new SearchResult();
        }

        TrieNode lastNode = getLastNode(data);
        return lastNode == null ? new SearchResult() : new SearchResult(true, lastNode.isEnd());
    }


    private TrieNode getLastNode(char... data) {
        TrieNode current = root;
        TrieNode endNode = current;
        for (int i = 0; i < data.length && current != null; ++i) {
            TrieNode next = current.next(data[i]);
            if (next == null) {
                return null;
            }
            endNode = current;
            current = next;
        }
        return endNode;
    }
}
