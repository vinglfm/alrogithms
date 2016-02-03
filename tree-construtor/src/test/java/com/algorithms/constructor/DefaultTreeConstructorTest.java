package com.algorithms.constructor;

import com.algorithms.model.Tree;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class DefaultTreeConstructorTest {

    private TreeConstructor treeConstructor;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() {
        treeConstructor = new DefaultTreeConstructor();
    }

    @Test
    public void addNodeThrowsIllegalArgumentExceptionForNullCurrentNodeData() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("currentNodeData shouldn't be null.");

        treeConstructor.addNode(null, "The", "Lazy");
    }

    @Test
    public void addNodeThrowsIllegalArgumentExceptionForNotUniqueNodes() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Tree shouldn't contain duplicate nodes.");

        treeConstructor.addNode("Fox","The","Lazy");
        treeConstructor.addNode("Quick","Fox","Jumps");
        treeConstructor.addNode("Fox", "Quick", "Brown");
    }

    @Test
    public void getRootOnNonConstructedTree() {
        Tree actualResult = treeConstructor.getRoot();

        assertThat(actualResult).isNull();
    }

    @Test
    public void constructTreeForSingleNodeWithNoChilds() {
        Tree expectedResult = new Tree("Fox");

        treeConstructor.addNode("Fox", null, null);

        Tree actualResult = treeConstructor.getRoot();
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void constructTreeForSingleNodeWithLeftChild() {
        Tree expectedResult = new Tree("Fox", new Tree("The"), null);

        treeConstructor.addNode("Fox", "The", null);

        Tree actualResult = treeConstructor.getRoot();
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void constructTreeForSingleNodeWithRightChild() {
        Tree expectedResult = new Tree("Fox", new Tree("The"), null);

        treeConstructor.addNode("Fox", "The", null);

        Tree actualResult = treeConstructor.getRoot();
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }

    @Test
    public void constructTreeForValidData() {
        Tree jumpsNode = new Tree("Jumps", new Tree("Dog"), null);
        Tree foxNode = new Tree("Fox", new Tree("The"), new Tree("Lazy"));
        Tree quickNode = new Tree("Quick", foxNode, jumpsNode);
        Tree brownNode = new Tree("Brown", null, new Tree("Over"));
        Tree expectedResult = new Tree("A", quickNode, brownNode);

        treeConstructor.addNode("Fox","The","Lazy");
        treeConstructor.addNode("Quick","Fox","Jumps");
        treeConstructor.addNode("Jumps","Dog", null);
        treeConstructor.addNode("Brown", null, "Over");
        treeConstructor.addNode("A","Quick","Brown");

        Tree actualResult = treeConstructor.getRoot();
        assertThat(actualResult).isEqualToComparingFieldByField(expectedResult);
    }
}