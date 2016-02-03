package com.algorithms.parser;

import com.algorithms.model.Tree;
import com.algorithms.validator.ValidationException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class FileParserTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void buildTreeThrowsIllegalArgumentExceptionForNullInput() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("reader shouldn't be null.");

        FileParser.buildTree(null);
    }

    @Test
    public void buildTreeForEmptyFile() {
        Tree actualTree = FileParser.buildTree(prepareInputStreamReader("empty.txt"));

        assertThat(actualTree).isNull();
    }

    @Test
    public void buildTreeThrowsRutimeExceptionForClosedInputStreamReader() throws IOException {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("java.io.IOException: Stream closed");

        InputStreamReader reader = prepareInputStreamReader("empty.txt");
        reader.close();

        FileParser.buildTree(reader);
    }

    @Test
    public void buildTreeThrowsInvalidTreeFormatExceptionWhenCurrentNodeIsEmpty() {
        expectedException.expect(InvalidTreeFormatException.class);
        expectedException.expectMessage("Current node couldn't be empty.");

        FileParser.buildTree(prepareInputStreamReader("emptyCurrentNode.txt"));
    }

    @Test
    public void buildTreeThrowsInvalidTreeFormatExceptionWhenLineHasTwoNodes() {
        expectedException.expect(InvalidTreeFormatException.class);
        expectedException.expectMessage("Line has to contain only 3 nodes.");

        FileParser.buildTree(prepareInputStreamReader("lineWithTwoNodes.txt"));
    }

    @Test
    public void buildTreeThrowsInvalidTreeFormatExceptionWhenLineHasFourNodes() {
        expectedException.expect(InvalidTreeFormatException.class);
        expectedException.expectMessage("Line has to contain only 3 nodes.");

        FileParser.buildTree(prepareInputStreamReader("lineWithFourNodes.txt"));
    }

    @Test
    public void buildTreeThrowsValidationExceptionForFileWithInvalidFormatData() {
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("23213,First,Next doesn't match patter: [a-zA-Z#,]+");

        FileParser.buildTree(prepareInputStreamReader("invalidDataNodes.txt"));
    }

    @Test
    public void buildTreeThrowsIllegalArgumentExceptionForNonUniqueData() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Tree shouldn't contain duplicate nodes.");

        FileParser.buildTree(prepareInputStreamReader("nonUniqueNodes.txt"));
    }

    @Test
    public void buildTreeCreatesValidTreeFromValidData() {
        Tree jumpsNode = new Tree("Jumps", new Tree("Dog"), null);
        Tree foxNode = new Tree("Fox", new Tree("The"), new Tree("Lazy"));
        Tree quickNode = new Tree("Quick", foxNode, jumpsNode);
        Tree brownNode = new Tree("Brown", null, new Tree("Over"));
        Tree expectedResult = new Tree("A", quickNode, brownNode);

        Tree actualTree = FileParser.buildTree(prepareInputStreamReader("validNodes.txt"));

        assertThat(actualTree).isEqualTo(expectedResult);
    }

    private InputStreamReader prepareInputStreamReader(String fileName) {
        return new InputStreamReader(getClass().getClassLoader().getResourceAsStream(fileName));
    }
}