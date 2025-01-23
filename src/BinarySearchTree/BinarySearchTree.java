package BinarySearchTree;
import BinaryTree.BinaryTree;

public class BinarySearchTree {
    BinaryTree rootNode;
    public BinarySearchTree() {
        this.rootNode = null;
    }

    public void insert(int data) {
        //이진탐색 트리가 null인 경우(처음 삽입하는 경우)
        if(this.rootNode == null) {
            this.rootNode = new BinaryTree(data, null, null);
            return;
        }
        //데이터가 1개 이상 존재하는 경우
        BinaryTree currentNode = this.rootNode;
        BinaryTree parentNode = null;

        while(currentNode != null) {
            parentNode = currentNode;
            if(currentNode.getData() > data) currentNode = currentNode.getLeftSubTree();
            else if (currentNode.getData() < data) currentNode = currentNode.getRightSubTree();
            else return; //이미 해당 데이터가 트리에 존재하는 경우 -> 중복을 허용하지 않으므로 그냥 종료
        }

        BinaryTree newNode = new BinaryTree(data, null, null);
        if(parentNode.getData() > data) parentNode.setLeftSubTree(newNode);
        else parentNode.setRightSubTree(newNode);

    }

    public BinaryTree search(int target) {
        BinaryTree currentNode = this.rootNode;
        while(currentNode != null) {
            if (currentNode.getData() == target) return currentNode;
            else if (currentNode.getData() > target) currentNode = currentNode.getLeftSubTree();
            else currentNode = currentNode.getRightSubTree();
        }
        return null;
    }

    public BinaryTree remove(int data) {
        if (rootNode == null) return null; // 트리가 비어 있는 경우

        BinaryTree fakeParent = new BinaryTree(0, null, null);
        fakeParent.setRightSubTree(rootNode);

        BinaryTree parentNode = fakeParent;
        BinaryTree currentNode = rootNode;

        while (currentNode != null && currentNode.getData() != data) {
            parentNode = currentNode;
            currentNode = (data < currentNode.getData())
                    ? currentNode.getLeftSubTree()
                    : currentNode.getRightSubTree();
        }

        if (currentNode == null) return null; // 삭제할 노드가 없는 경우

        if (currentNode.getLeftSubTree() == null || currentNode.getRightSubTree() == null) {
            // 1, 2 경우 처리
            BinaryTree child = (currentNode.getLeftSubTree() != null)
                    ? currentNode.getLeftSubTree()
                    : currentNode.getRightSubTree();
            // 삭제할 노드의 유일한 자식 노드를 가리키거나 자식 노드가 없다면 null이 됨

            if (parentNode.getLeftSubTree() == currentNode) parentNode.setLeftSubTree(child);
            else parentNode.setRightSubTree(child);
        } else {
            // 3 처리
            BinaryTree replacingParent = currentNode;
            BinaryTree replacingNode = currentNode.getLeftSubTree();

            while (replacingNode.getRightSubTree() != null) {
                replacingParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            if (replacingParent != currentNode) replacingParent.setRightSubTree(replacingNode.getLeftSubTree());
            replacingNode.setLeftSubTree(currentNode.getLeftSubTree());
            replacingNode.setRightSubTree(currentNode.getRightSubTree());

            if (parentNode.getLeftSubTree() == currentNode) parentNode.setLeftSubTree(replacingNode);
            else parentNode.setRightSubTree(replacingNode);
        }

        if (fakeParent.getRightSubTree() != rootNode) rootNode = fakeParent.getRightSubTree();
        return currentNode;
    }

}
