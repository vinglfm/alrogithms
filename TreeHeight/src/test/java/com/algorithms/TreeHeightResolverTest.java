package com.algorithms;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThat;

public class TreeHeightResolverTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void throwsIllegalArgumentExceptionForNullTree() {

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("root node shouldn't be null.");

        TreeHeightResolver treeHeightResolver = new TreeHeightResolver();
        treeHeightResolver.findTreeHeight(null);

    }

    @Test
    public void findHeightForEmptyTree() {
        TreeHeightResolver treeHeightResolver = new TreeHeightResolver();

        int expectedResult = 1;

        Node<Integer> singleNodeTree = new Node<>(10);

        int actualResult = treeHeightResolver.findTreeHeight(singleNodeTree);

        assertThat(actualResult).isEqualTo(expectedResult);
    }


    @Test
    public void findHeightForTreeWithHigherLeftNode() {
        TreeHeightResolver treeHeightResolver = new TreeHeightResolver();

        int expectedResult = 3;

        Node<Integer> root = new Node<>(10);
        Node<Integer> firstLeft = new Node<>(15);
        root.setLeft(firstLeft);
        root.setRight(new Node(12));
        firstLeft.setLeft(new Node<>(26));

        int actualResult = treeHeightResolver.findTreeHeight(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void findHeightForTreeWithHigherRightNode() {
        TreeHeightResolver treeHeightResolver = new TreeHeightResolver();

        int expectedResult = 3;

        Node<Integer> root = new Node<>(10);
        Node<Integer> firstRight = new Node<>(15);
        root.setRight(firstRight);
        root.setLeft(new Node(12));
        firstRight.setLeft(new Node<>(26));

        int actualResult = treeHeightResolver.findTreeHeight(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    public void findHeightForTreeWithSimilarHeight() {
        TreeHeightResolver treeHeightResolver = new TreeHeightResolver();

        int expectedResult = 3;

        Node<Integer> root = new Node<>(10);
        Node<Integer> firstRight = new Node<>(15);
        Node firstLeft = new Node(12);
        root.setRight(firstRight);
        root.setLeft(firstLeft);
        firstRight.setLeft(new Node<>(26));
        firstLeft.setRight(new Node<>(30));

        int actualResult = treeHeightResolver.findTreeHeight(root);

        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
