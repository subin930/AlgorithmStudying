package RBTree;

public class RBTreeExample {
    public static void main(String[] args) {
        RBTree rbTree = new RBTree();

        rbTree.insert(17);
        rbTree.insert(9);
        rbTree.insert(19);
        rbTree.insert(75);
        rbTree.insert(85);

        System.out.println(rbTree.rootNode.getData());

        if(rbTree.rootNode != null) {
            rbTree.rootNode.inOrderTraversal(rbTree.rootNode);
        }
    }
}
