public class LinkListExample {
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
        Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
    }

    private static class LinkedList {
        Node head;
        int count;

        LinkedList() {
            this.head = null;
            count = 0;
        }

        void printAll() {
            Node currentNode = this.head;
            System.out.print("[");
            while(currentNode != null){
                System.out.print(currentNode.data);
                if(currentNode.next != null){
                    System.out.print(", ");
                }
                currentNode = currentNode.next;
            }
            System.out.println("]");
        }

        void clear(){
            this.head = null;
            this.count = 0;
        }

        void insertAt(int index, int data) throws Exception {
            //예외처리: 인덱스의 범위 확인
            if(index < 0 || index > count) {
                throw new Exception("범위를 넘어갔습니다.");
            }

            Node newNode = new Node(data);
            if(index == 0){
                newNode.next = this.head;
                this.head = newNode;
            } else {
                Node currentNode = this.head;
                for(int i = 0; i < index - 1; ++i) {
                    currentNode = currentNode.next;
                }
                newNode.next = currentNode.next;
                currentNode.next = newNode;
            }
            ++this.count;
        }

        void insertLast(int data) throws Exception {
            this.insertAt(count, data);
        }

        Node deleteAt(int index) throws Exception {
            //예외처리: 인덱스의 범위 확인
            if(index < 0 || index > count) {
                throw new Exception("범위를 넘어갔습니다.");
            }
            Node deletedNode;
            if(index == 0){
                deletedNode = this.head;
                this.head = this.head.next;
            } else {
                Node currentNode = this.head;
                for(int i = 0; i < index - 1; ++i){
                    currentNode = currentNode.next;
                }
                deletedNode = currentNode.next;
                currentNode.next = currentNode.next.next;
            }
            --this.count;
            return deletedNode;
        }

        Node deleteLast() throws Exception {
            return this.deleteAt(count - 1);
        }

        Node getNodeAt(int index) throws Exception {
            //예외처리: 인덱스의 범위 확인
            if(index < 0 || index > count) {
                throw new Exception("범위를 넘어갔습니다.");
            }

            Node currentNode = this.head;
            for(int i = 0; i < index; ++i){
                currentNode = currentNode.next;
            }
            return currentNode;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("===== Node Test =====");
        Node node2 = new Node(2);
        Node node1 = new Node(1, node2);
        Node node0 = new Node(0, node1);
        System.out.println(node0.data);
        System.out.println(node0.next.data);
        System.out.println(node0.next.next.data);

        System.out.println("===== insertAt Test =====");
        LinkedList linkedList = new LinkedList();
        linkedList.insertAt(0, 0);
        linkedList.insertAt(1, 1);
        linkedList.insertAt(2, 2);
        linkedList.printAll();

        System.out.println("===== clearAll Test =====");
        linkedList.clear();
        linkedList.printAll();

        System.out.println("===== insertLast Test =====");
        linkedList.insertAt(0, 0);
        linkedList.insertAt(1, 1);
        linkedList.insertAt(2, 2);
        linkedList.insertLast(3);
        linkedList.printAll();

        System.out.println("===== deleteAt Test =====");
        linkedList.deleteAt(2);
        linkedList.printAll();

        System.out.println("===== deleteLast Test =====");
        linkedList.deleteLast();
        linkedList.printAll();

        System.out.println("===== getNode Test =====");
        Node testNode1 = linkedList.getNodeAt(1);
        Node testNode2 = linkedList.getNodeAt(0);
        System.out.println(testNode1.data);
        System.out.println(testNode2.data);
    }
}
