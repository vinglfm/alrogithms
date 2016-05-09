package datastructures;

public class SearchResult {
    private final boolean isPresent;
    private final boolean isWord;

    public SearchResult() {
        this(false, false);
    }

    public SearchResult(boolean isPresent, boolean isWord) {
        this.isPresent = isPresent;
        this.isWord = isWord;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public boolean isWord() {
        return isWord;
    }
}
