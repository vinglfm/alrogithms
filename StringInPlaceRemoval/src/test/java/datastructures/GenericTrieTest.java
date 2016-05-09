package datastructures;

import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(Enclosed.class)
public class GenericTrieTest {

    @RunWith(Parameterized.class)
    public static class AddTestCase {
        @Parameterized.Parameters(name = "{index}: data = {0}")
        public static Collection<Object[]> data() {
            return Arrays.asList(
                    new Object[][]{
                            {"s"}, {"element"}, {"pp"}, {"A"}, {"ELEMENT"}, {"PP"}, {"Pumpkin"}
                    });
        }

        private final String data;

        public AddTestCase(String data) {
            this.data = data;
        }

        @Test
        public void add() {
            GenericTrie genericTrie = new GenericTrie();

            char[] chars = this.data.toCharArray();
            SearchResult before = genericTrie.contains(chars);
            assertThat(before.isPresent()).isFalse();
            assertThat(before.isWord()).isFalse();

            genericTrie.add(chars);

            SearchResult after = genericTrie.contains(chars);
            assertThat(after.isPresent()).isTrue();
            assertThat(after.isWord()).isTrue();
        }
    }

    public static class ContainsTestCase {

        @Test
        public void containsReturnsFalseForNoArguments() {
            GenericTrie genericTrie = new GenericTrie();

            genericTrie.add('a');

            SearchResult actualResult = genericTrie.contains();
            assertThat(actualResult.isPresent()).isFalse();
            assertThat(actualResult.isWord()).isFalse();
        }

        @Test
        public void containsReturnsFalseForEmptyTrie() {
            GenericTrie genericTrie = new GenericTrie();

            char[] chars = "chars".toCharArray();
            SearchResult actualResult = genericTrie.contains(chars);
            assertThat(actualResult.isPresent()).isFalse();
            assertThat(actualResult.isWord()).isFalse();
        }

        @Test
        public void containsReturnsFalseForNoArgumentsAndEmptyTrie() {
            GenericTrie genericTrie = new GenericTrie();

            SearchResult actualResult = genericTrie.contains();
            assertThat(actualResult.isPresent()).isFalse();
            assertThat(actualResult.isWord()).isFalse();
        }

        @Test
        public void containsReturnsFalseIfNoMatch() {
            GenericTrie genericTrie = new GenericTrie();

            char[] chars = "chars".toCharArray();
            genericTrie.add(chars);

            char[] toMatch = "b".toCharArray();

            SearchResult actualResult = genericTrie.contains(toMatch);
            assertThat(actualResult.isPresent()).isFalse();
            assertThat(actualResult.isWord()).isFalse();
        }

        @Test
        public void containsReturnsIsPresentForPartialMatch() {
            GenericTrie genericTrie = new GenericTrie();

            char[] chars = "chars".toCharArray();
            genericTrie.add(chars);

            char[] toMatch = "cha".toCharArray();

            SearchResult actualResult = genericTrie.contains(toMatch);
            assertThat(actualResult.isPresent()).isTrue();
            assertThat(actualResult.isWord()).isFalse();
        }

        @Test
        public void containsReturnsIsPresentAndIsWordForFullMatch() {
            GenericTrie genericTrie = new GenericTrie();

            char[] chars = "chars".toCharArray();
            genericTrie.add(chars);

            char[] toMatch = "chars".toCharArray();

            SearchResult actualResult = genericTrie.contains(toMatch);
            assertThat(actualResult.isPresent()).isTrue();
            assertThat(actualResult.isWord()).isTrue();
        }
    }

    public static class CornerCasesGenericTrieTest {

        @Rule
        public ExpectedException expectedException = ExpectedException.none();

        @Test
        public void addThrowsIllegalArgumentExceptionForNullData() {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("data can't be null.");

            GenericTrie genericTrie = new GenericTrie();
            genericTrie.add(null);
        }

        @Test
        public void containsThrowsIllegalArgumentExceptionForNullData() {
            expectedException.expect(IllegalArgumentException.class);
            expectedException.expectMessage("data can't be null.");

            GenericTrie genericTrie = new GenericTrie();
            genericTrie.contains(null);
        }

        @Test
        public void addEmptyString() {
            GenericTrie genericTrie = new GenericTrie();

            char[] data = "".toCharArray();
            assertThat(genericTrie.contains(data).isWord()).isFalse();
            genericTrie.add(data);
            assertThat(genericTrie.contains(data).isWord()).isFalse();
        }
    }

}