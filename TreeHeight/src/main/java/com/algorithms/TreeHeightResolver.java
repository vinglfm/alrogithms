package com.algorithms;

import com.algorithms.validation.PredicateValidator;
import com.algorithms.validation.Validator;

import static java.lang.Math.max;

public class TreeHeightResolver {

    private static final int NODE_HEIGHT = 1;
    private Validator validator = new PredicateValidator();

    public <T> int findTreeHeight(Node<T> rootNode) {
        validator.validate(root -> root == null, rootNode, "root node shouldn't be null.");

        return max(findTreeHeight(rootNode.getLeft(), NODE_HEIGHT),
                findTreeHeight(rootNode.getRight(), NODE_HEIGHT));
    }

    private <T> int findTreeHeight(Node<T> treeNode, int currentHeight) {
        if (treeNode == null) {
            return currentHeight;
        }

        return max(findTreeHeight(treeNode.getLeft(), currentHeight + NODE_HEIGHT),
                findTreeHeight(treeNode.getRight(), currentHeight + NODE_HEIGHT));
    }
}
