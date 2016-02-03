package com.algorithms.model;

public class Tree {
    private String data;
    private Tree left;
    private Tree right;
    private Tree parent;

    public Tree(String data) {
        this.data = data;
    }

    public Tree(String data, Tree left, Tree right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Tree getLeft() {
        return left;
    }

    public void setLeft(Tree left) {
        this.left = left;
    }

    public Tree getRight() {
        return right;
    }

    public void setRight(Tree right) {
        this.right = right;
    }

    public Tree getParent() {
        return parent;
    }

    public void setParent(Tree parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tree tree = (Tree) o;

        if (data != null ? !data.equals(tree.data) : tree.data != null) return false;
        if (left != null ? !left.equals(tree.left) : tree.left != null) return false;
        return !(right != null ? !right.equals(tree.right) : tree.right != null);

    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "data='" + data + '\'' +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
