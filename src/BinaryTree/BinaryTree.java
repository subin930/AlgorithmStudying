package BinaryTree;

public class BinaryTree {
    int data;
    BinaryTree leftTree;
    BinaryTree rightTree;

    public BinaryTree(int data, BinaryTree leftTree, BinaryTree rightTree) {
        this.data = data;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTree getLeftSubTree() {
        return this.leftTree;
    }

    public BinaryTree getRightSubTree() {
        return this.rightTree;
    }

    public void setLeftSubTree(BinaryTree leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightSubTree(BinaryTree rightTree) {
        this.rightTree = rightTree;
    }

    public BinaryTree removeLeftSubTree() {
        BinaryTree deleteingNode = this.leftTree;
        this.setLeftSubTree(null);
        return deleteingNode;
    }

    public BinaryTree removeRightSubTree() {
        BinaryTree deleteingNode = this.rightTree;
        this.setRightSubTree(null);
        return deleteingNode;
    }

    public void preOrderTraversal(BinaryTree tree) {
        if (tree == null) return;
        System.out.printf("%d ", tree.data);
        preOrderTraversal(tree.getLeftSubTree());
        preOrderTraversal(tree.getRightSubTree());
    }

    public void inOrderTraversal(BinaryTree tree) {
        if (tree == null) return;
        inOrderTraversal(tree.getLeftSubTree());
        System.out.printf("%d ", tree.data);
        inOrderTraversal(tree.getRightSubTree());
    }

    public void postOrderTraversal(BinaryTree tree) {
        if (tree == null) return;
        postOrderTraversal(tree.getLeftSubTree());
        postOrderTraversal(tree.getRightSubTree());
        System.out.printf("%d ", tree.data);
    }
}
