package datastructures;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TrieNodeTest {

    @Test
    public void nextReturnsNullForNotPresentElement() {
        char elem = 'c';

        TrieNode trieNode = new TrieNode();

        TrieNode nextNode = trieNode.next(elem);
        assertThat(nextNode).isNull();
    }

    @Test
    public void nextReturnsTrieNodeForPresentElement() {
        char elem = 'c';

        TrieNode trieNode = new TrieNode();

        TrieNode nextNode = trieNode.next(elem);
        assertThat(nextNode).isNull();
    }

    @Test
    public void putAddsTrieNodeIfNotExist() {
        char elem = 'c';

        TrieNode trieNode = new TrieNode();

        trieNode.put(elem);
        assertThat(trieNode.next(elem)).isNotNull();
    }

    @Test
    public void putDoNotAddTrieNodeIfAlreadyExists() {
        char elem = 'c';

        TrieNode trieNode = new TrieNode();

        trieNode.put(elem);
        TrieNode first = trieNode.next(elem);
        trieNode.put(elem);
        TrieNode second = trieNode.next(elem);

        assertThat(first).isNotNull();
        assertThat(second).isNotNull();
        assertThat(first).isSameAs(second);
    }
}