package avlTree;

public class avlTreeExample {
    public static void main(String[] args) {
        System.out.println("===== insert =====");
        avlTree tree = new avlTree(null);
        tree.insert(tree.rootNode, 1);
        tree.insert(tree.rootNode, 2);
        tree.insert(tree.rootNode, 3);
        tree.insert(tree.rootNode, 4);
        tree.insert(tree.rootNode, 5);
        tree.insert(tree.rootNode, 6);
        tree.insert(tree.rootNode, 7);

        System.out.printf("rootNode: %d\n", tree.rootNode.getData());
        tree.rootNode.inOrderTraversal(tree.rootNode);
        System.out.println();

        System.out.println("===== remove =====");
        System.out.println("===== remove 2=====");
        tree.remove(tree.rootNode, 2, null);
        System.out.println("===== remove 3=====");
        tree.remove(tree.rootNode, 3, null);
        System.out.println("===== remove 1=====");
        tree.remove(tree.rootNode, 1, null);
        System.out.printf("rootNode: %d\n", tree.rootNode.getData());
        tree.rootNode.inOrderTraversal(tree.rootNode);
        System.out.println();

        System.out.println("===== search =====");
        System.out.printf("search 7: %d\n", tree.search(7).getData());
    }
}
