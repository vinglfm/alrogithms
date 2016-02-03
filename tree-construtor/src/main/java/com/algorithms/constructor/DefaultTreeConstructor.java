package com.algorithms.constructor;

import com.algorithms.model.Tree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DefaultTreeConstructor implements TreeConstructor {

    private final Map<String, Tree> treeNodes = new HashMap<>();

    public void addNode(String currentNodeData, String leftNodeData, String rightNodeData) {

        if (currentNodeData == null) {
            throw new IllegalArgumentException("currentNodeData shouldn't be null.");
        }

        Tree current = prepareNode(currentNodeData);
        Tree left = prepareChildNode(leftNodeData, current);
        Tree right = prepareChildNode(rightNodeData, current);

        validateUniqueness(current);

        current.setLeft(left);
        current.setRight(right);
    }

    private void validateUniqueness(Tree current) {
        if(current.getLeft() != null || current.getRight() != null) {
            throw new IllegalArgumentException("Tree shouldn't contain duplicate nodes.");
        }
    }

    public Tree getRoot() {
        Iterator<Tree> nodeIterator = treeNodes.values().iterator();
        if(!nodeIterator.hasNext()) {
            return null;
        }

        Tree treeNode = nodeIterator.next();
        while (treeNode != null && treeNode.getParent() != null) {
            treeNode = treeNode.getParent();
        }
        return treeNode;
    }

    private Tree prepareNode(String node) {
        if (!treeNodes.containsKey(node)) {
            treeNodes.put(node, new Tree(node));
        }

        return treeNodes.get(node);
    }

    private Tree prepareChildNode(String node, Tree parent) {
        Tree tree = null;
        if (node != null) {
            tree = prepareNode(node);
            tree.setParent(parent);
        }
        return tree;
    }
}
