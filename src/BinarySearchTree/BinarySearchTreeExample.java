package BinarySearchTree;

public class BinarySearchTreeExample {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(18);
        tree.insert(15);
        tree.insert(10);
        tree.insert(6);
        tree.insert(3);
        tree.insert(8);
        tree.insert(12);
        tree.insert(11);
        tree.insert(31);
        tree.insert(27);
        tree.insert(24);
        tree.insert(20);
        tree.insert(33);
        tree.insert(35);
        tree.insert(37);
        tree.rootNode.inOrderTraversal(tree.rootNode);
        System.out.println();

        System.out.println(tree.search(6).getData());

        System.out.println(tree.search(1));

        tree.remove(10);
        tree.rootNode.inOrderTraversal(tree.rootNode);
    }
}
