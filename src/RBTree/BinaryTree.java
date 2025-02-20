package RBTree;


public class BinaryTree {
    int data;
    BinaryTree leftTree;
    BinaryTree rightTree;
    BinaryTree parentTree;
    char color;

    public BinaryTree(int data) {
        this.data = data;
        this.leftTree = null;
        this.rightTree = null;
        this.parentTree = null;
        this.color = 'R';
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

    public BinaryTree getParentTree() { return this.parentTree; }

    public void setLeftSubTree(BinaryTree leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightSubTree(BinaryTree rightTree) {
        this.rightTree = rightTree;
    }

    public void setParentTree(BinaryTree parentTree) { this.parentTree = parentTree; }

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
