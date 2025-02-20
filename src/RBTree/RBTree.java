package RBTree;

class NilNode extends BinaryTree {
    public NilNode() {
        super(0);
        this.color = 'B';
    }
}

public class RBTree {
    BinaryTree rootNode;
    public RBTree() {
        this.rootNode = null;
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

    public void rotateLeft(BinaryTree node) {
        BinaryTree parentNode = node.getParentTree();
        BinaryTree rightChildNode = node.getRightSubTree();

        //rightChildNode의 왼쪽 자식노드를 node의 오른쪽 자식 노드로 설정
        node.setRightSubTree(rightChildNode.getLeftSubTree());

        //rightChildNode의 왼쪽 자식 노드가 Nil노드가 아니라면 부모를 node로 설정
        if(rightChildNode.getLeftSubTree() != null) {
            rightChildNode.getLeftSubTree().setParentTree(node);
        }

        //rightChildNode의 왼쪽 자식 노드를 node로 설정
        rightChildNode.setLeftSubTree(node);
        node.setParentTree(rightChildNode);

        //node의 부모노드에 rightChild 연결
        this.replaceParentChild(parentNode, node, rightChildNode);
    }

    public void rotateRight(BinaryTree node) {
        BinaryTree parentNode = node.getParentTree();
        BinaryTree leftChildNode = node.getLeftSubTree();

        //leftChildeNode의 오른쪽 자식 노드를 node의 왼쪽 자식 노드로 연결
        node.setLeftSubTree(leftChildNode.getRightSubTree());

        if(leftChildNode.getRightSubTree() != null) {
            leftChildNode.getRightSubTree().setParentTree(node);
        }

        //leftChildNode의 오른쪽 자식 노드를 node로 설정
        leftChildNode.setRightSubTree(node);
        node.setParentTree(leftChildNode);

        //node의 부모 노드와 leftChildNode 연결
        this.replaceParentChild(parentNode, node, leftChildNode);
    }

    public void replaceParentChild(BinaryTree parent, BinaryTree oldChild, BinaryTree newChild) {
        //부모->자식 연결
        if(parent == null) {
            //루트 노드인 경우
            this.rootNode = newChild;
        } else if(parent.getLeftSubTree() == oldChild) {
            parent.setLeftSubTree(newChild);
        } else if(parent.getRightSubTree() == oldChild) {
            parent.setRightSubTree(newChild);
        }
        //부모 <- 자식 연결
        if(newChild != null) {
            newChild.setParentTree(parent);
        }
    }

    public void insert(int data) {
        BinaryTree currentNode = this.rootNode;
        BinaryTree parentNode = null;

        while(currentNode != null) {
            parentNode = currentNode;
            if(currentNode.getData() > data) {
                currentNode = currentNode.getLeftSubTree();
            } else if(currentNode.getData() < data) {
                currentNode = currentNode.getRightSubTree();
            } else {
                //중복 데이터인 경우
                return;
            }
        }

        BinaryTree newNode = new BinaryTree(data);

        if(parentNode == null) {
            this.rootNode = newNode;
        } else if(parentNode.getData() > data) {
            parentNode.setLeftSubTree(newNode);
        } else {
            parentNode.setRightSubTree(newNode);
        }

        newNode.setParentTree(parentNode);
        this.rebalnceAfterInsertion(newNode);
    }

    public void rebalnceAfterInsertion(BinaryTree node) {
        /*
        1. 삽입한 노드가 루트 노드인 경우
        2. 부모노드와 삼촌노드(부모의 형제노드)가 빨간색인 경우
        3. 부모 노드는 빨간색, 삼촌 노드는 검은색, 새로운 노드는 안쪽 손자(부모노드의 왼쪽 자식노드)인 경우
        4. 부모 노드는 빨간색, 삼촌 노드는 검은색, 새로운 노드는 바깥쪽 손자인 경우
         */

        BinaryTree parentNode = node.getParentTree();

        //1번 경우 처리
        if(parentNode == null) {
            //루트노드인 경우
            node.color = 'B';
            return;
        }

        if(parentNode.color == 'B') {
            return;
        }

        BinaryTree uncleNode = getUncle(parentNode);
        BinaryTree grandParentNode = parentNode.getParentTree();

        //2번 경우 처리
        if(uncleNode != null && uncleNode.color == 'R') {
            grandParentNode.color = 'R';
            parentNode.color = 'B';
            uncleNode.color = 'B';
            rebalnceAfterInsertion(grandParentNode);
        }
        if (isBlack(uncleNode)){
            //3번 경우 처리
            if(grandParentNode.getRightSubTree() == parentNode && parentNode.getLeftSubTree() == node) {
                rotateRight(parentNode);
                rotateLeft(grandParentNode);
                node.color = 'B';
                grandParentNode.color = 'R';
            } else if(grandParentNode.getLeftSubTree() == parentNode && parentNode.getRightSubTree() == node) {
                rotateLeft((parentNode));
                rotateRight(grandParentNode);
                node.color = 'B';
                grandParentNode.color = 'R';
            }
            //4번 경우 처리
            else if(grandParentNode.getRightSubTree() == parentNode && parentNode.getRightSubTree() == node) {
                rotateLeft(grandParentNode);
                parentNode.color = 'B';
                grandParentNode.color = 'R';
            } else if(grandParentNode.getLeftSubTree() == parentNode && parentNode.getLeftSubTree() == node) {
                rotateRight(grandParentNode);
                parentNode.color = 'B';
                grandParentNode.color = 'R';
            }
        }


    }

    public BinaryTree getUncle(BinaryTree parentNode) {
        BinaryTree grandParentNode = parentNode.getParentTree();

        if(grandParentNode == null) {
            return null;
        }

        if(grandParentNode.getRightSubTree() == parentNode) {
            return grandParentNode.getLeftSubTree();
        } else if(grandParentNode.getLeftSubTree() == parentNode) {
            return grandParentNode.getRightSubTree();
        }

        return null;
    }

    public boolean isBlack(BinaryTree node) {
        return node == null || node.color == 'B';
    }
}
