package LinkedList;

public class LinkedList {
    public Node head;
    public int count;

    public LinkedList() {
        this.head = null;
        count = 0;
    }

    public void printAll() {
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

    public void clear(){
        this.head = null;
        this.count = 0;
    }

    public void insertAt(int index, int data) throws Exception {
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

    public void insertLast(int data) throws Exception {
        this.insertAt(count, data);
    }

    public Node deleteAt(int index) throws Exception {
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

    public Node deleteLast() throws Exception {
        return this.deleteAt(count - 1);
    }

    public Node getNodeAt(int index) throws Exception {
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
