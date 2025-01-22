package BinaryTree;

public class BinaryTreeExample {
    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(1, null, null);
        BinaryTree tree2 = new BinaryTree(2, null, null);
        BinaryTree tree3 = new BinaryTree(3, null, null);
        BinaryTree tree4 = new BinaryTree(4, null, null);
        BinaryTree tree5 = new BinaryTree(5, null, null);
        BinaryTree tree6 = new BinaryTree(6, null, null);
        BinaryTree tree7 = new BinaryTree(7, null, null);
        tree1.setLeftSubTree(tree2);
        tree1.setRightSubTree(tree3);
        tree2.setLeftSubTree(tree4);
        tree2.setRightSubTree(tree5);
        tree3.setLeftSubTree(tree6);
        tree3.setRightSubTree(tree7);

        System.out.printf("루트 노드의 왼쪽 자식 노드: %d\n", tree1.getLeftSubTree().getData());
        System.out.printf("루트 노드의 왼쪽 자식 노드의 오른쪽 자식 노드: %d\n", tree1.getLeftSubTree().getRightSubTree().getData());

        System.out.println("전위 순회");
        tree1.preOrderTraversal(tree1);
        System.out.println();

        System.out.println("중위 순회");
        tree1.inOrderTraversal(tree1);
        System.out.println();

        System.out.println("후위 순회");
        tree1.postOrderTraversal(tree1);
        System.out.println();
    }
}
