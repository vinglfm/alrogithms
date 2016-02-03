package com.algorithms.constructor;

import com.algorithms.model.Tree;

public interface TreeConstructor {
    void addNode(String currentNodeData, String leftNodeData, String rightNodeData);

    Tree getRoot();
}
