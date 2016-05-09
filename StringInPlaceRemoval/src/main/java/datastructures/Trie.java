package datastructures;

public interface Trie {

    void add(char... data);

    SearchResult contains(char... data);
}
