package avlTree;

public class avlTree {
    BinaryTree rootNode;
    public avlTree(BinaryTree rootNode) {
        this.rootNode = rootNode;
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

    public int getHeight(BinaryTree node) {
        if(node == null) return 0;
        return node.height;
    }

    public void updateHeight(BinaryTree node) {
        int leftChildHeight = this.getHeight(node.getLeftSubTree());
        int rightChildHeight = this.getHeight(node.getRightSubTree());
        node.height = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    public int getBalanceFactor(BinaryTree node) {
        return this.getHeight(node.getLeftSubTree()) - this.getHeight(node.getRightSubTree());
        //양수라면 왼쪽이 높이가 더 큼
    }

    public BinaryTree rotateLeft(BinaryTree node) {
        BinaryTree rightChild = node.getRightSubTree();
        node.setRightSubTree(rightChild.getLeftSubTree());
        rightChild.setLeftSubTree(node);

        this.updateHeight(rightChild);
        this.updateHeight(node);

        return rightChild; //바뀐 루트 노드 리턴
    }

    public BinaryTree rotateRight(BinaryTree node) {
        BinaryTree leftChild = node.getLeftSubTree();
        node.setLeftSubTree(leftChild.getRightSubTree());
        leftChild.setRightSubTree(node);

        this.updateHeight(leftChild);
        this.updateHeight(node);

        return leftChild;
    }
    /*
    child 노드들의 높이를 분석하여 LL회전, RR회전, LR회전, RL회전 중 어떤 회전을 할 것인지 결정
     targetNode: 회전시킬 노드
     data: 트리를 무너트린 노드의 데이터
     */
    public BinaryTree rotation(BinaryTree targetNode, int data) {
        int balanceFactor = this.getBalanceFactor(targetNode); //양수라면 왼쪽이 높이가 더 큼
        boolean isRoot = (targetNode == this.rootNode);

        if(balanceFactor < -1 && data > targetNode.getRightSubTree().getData()) {
            //LL 회전을 적용 해야 하는 경우
            targetNode = this.rotateLeft(targetNode);
        } else if(balanceFactor > 1 && data < targetNode.getLeftSubTree().getData()) {
            //RR 회전을 적용 해야 하는 경우
            targetNode = this.rotateRight(targetNode);
        } else if(balanceFactor < -1 && data < targetNode.getRightSubTree().getData()) {
            //LR 회전을 적용 해야 하는 경우
            targetNode.setLeftSubTree(this.rotateLeft(targetNode.getLeftSubTree()));
            targetNode = this.rotateRight(targetNode);
        } else if(balanceFactor > 1 && data > targetNode.getRightSubTree().getData()) {
            targetNode.setRightSubTree(this.rotateRight(targetNode.getRightSubTree()));
            targetNode = this.rotateLeft(targetNode);
        }

        if(isRoot) this.rootNode = targetNode;

        return targetNode;
    }

    //균형을 무너트리는 데이터를 찾는 함수(제거 시 사용)
    public BinaryTree getUnbalanceNode(BinaryTree targetRootNode, BinaryTree unBalancedNode) {
        if(targetRootNode.getRightSubTree() == null && targetRootNode.getLeftSubTree() == null) {
            unBalancedNode = targetRootNode;
            return unBalancedNode;
        }

        int balanceFactor = this.getBalanceFactor(targetRootNode);

        if(balanceFactor > 0) {
            unBalancedNode = this.getUnbalanceNode(targetRootNode.getLeftSubTree(), unBalancedNode);
        } else if(balanceFactor < 0) {
            unBalancedNode = this.getUnbalanceNode(targetRootNode.getRightSubTree(), unBalancedNode);
        } else {
            unBalancedNode = targetRootNode.getRightSubTree();
        }

        return unBalancedNode;
    }

    /*
    삽입 함수(재귀 함수)
     */
    public BinaryTree insert(BinaryTree targetRootNode, int data) {
        if(targetRootNode == null) {
            //삽입하려는 노드가 비어있는 상태: 트리에 처음 데이터를 삽입 or 터미널 노드에 삽입
            targetRootNode = new BinaryTree(data, null, null);
        }

        //트리에 처음 데이터를 삽입하는 경우
        if(this.rootNode == null) {
            this.rootNode = targetRootNode;
        } else if(targetRootNode.getData() == data) {
            //증복 데이터를 삽입하는 경우: 허용 x or 초기 targetRootNode가 null이었던 경우 빠져나감
            return targetRootNode;
        } else if(targetRootNode.getData() > data) {
            targetRootNode.setLeftSubTree(this.insert(targetRootNode.getLeftSubTree(), data));
        } else {
            targetRootNode.setRightSubTree(this.insert(targetRootNode.getRightSubTree(), data));
        }

        this.updateHeight(targetRootNode);
        targetRootNode = this.rotation(targetRootNode, data);

        return targetRootNode;
    }

    /*
    제거 함수(재귀 함수)
    parentNode: targetRootNode 의 부모 노드
     */
    public BinaryTree remove(BinaryTree targetRootNode, int data, BinaryTree parentNode) {
        if(targetRootNode.getData() > data) {
            //삭제하려는 데이터가 더 작은 경우
            targetRootNode.setLeftSubTree(this.remove(targetRootNode.getLeftSubTree(), data, targetRootNode));
        } else if(targetRootNode.getData() < data) {
            targetRootNode.setRightSubTree(this.remove(targetRootNode.getRightSubTree(), data, targetRootNode));
        } else {
            //해당 노드가 제거하려는 노드인 경우
            targetRootNode = this.removeHelper(targetRootNode, data, parentNode);

            //루트 노드를 제거하려는 경우
            if(parentNode == null && targetRootNode != null) {
                this.updateHeight(targetRootNode);
                BinaryTree unBalanceNode = this.getUnbalanceNode(targetRootNode, null);
                targetRootNode = this.rotation(targetRootNode, unBalanceNode.getData());
            }
            return targetRootNode;
        }

        this.updateHeight(targetRootNode);
        BinaryTree unBalanceNode = this.getUnbalanceNode(targetRootNode, null);
        targetRootNode = this.rotation(targetRootNode, unBalanceNode.getData());
        return targetRootNode;
    }

    /*
    해당 노드를 삭제하고 대체되는 노드를 리턴하는 함수
     */
    public BinaryTree removeHelper(BinaryTree deletingNode, int data, BinaryTree parentNode) {
        if (rootNode == null) return null; // 트리가 비어 있는 경우

        BinaryTree replacingNode = null;

        if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
            // 1(삭제하려는 노드의 자식 노드가 x), 2(삭제하려는 노드의 자식 노드가 1개) 경우 처리
            replacingNode = (deletingNode.getLeftSubTree() != null)
                    ? deletingNode.getLeftSubTree()
                    : deletingNode.getRightSubTree();
            // 삭제할 노드의 유일한 자식 노드를 가리키거나 자식 노드가 없다면 null이 됨
            if(parentNode != null) {
                if (parentNode.getLeftSubTree() == deletingNode) parentNode.setLeftSubTree(replacingNode);
                else parentNode.setRightSubTree(replacingNode);
            } else {
                //삭제 대상이 루트 노드인 경우
                this.rootNode = replacingNode;
            }

        } else {
            // 3(삭제하려는 노드의 자식 노드가 2개인 경우) 처리: 왼쪽 subtree 중에서 가장 큰 것 선택
            BinaryTree replacingParent = deletingNode;
            replacingNode = deletingNode.getLeftSubTree();

            while (replacingNode.getRightSubTree() != null) {
                replacingParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            //대체할 노드의 부모와 연결 해제 및 왼쪽 자식 연결
            if(replacingParent != deletingNode) {
                replacingParent.setRightSubTree(replacingNode.getLeftSubTree());
                replacingNode.setLeftSubTree(deletingNode.getLeftSubTree());
            }

            replacingNode.setRightSubTree(deletingNode.getRightSubTree());

            //부모 노드의 자식 포인터 업데이트
            if(parentNode != null) {
                if (parentNode.getLeftSubTree() == deletingNode) {
                    parentNode.setLeftSubTree(replacingNode);
                } else {
                    parentNode.setRightSubTree(replacingNode);
                }
            } else {
                // 삭제하려는 노드가 루트 노드인 경우
                this.rootNode = replacingNode;
            }
        }
        return replacingNode;
    }
}
