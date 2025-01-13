package DoublyLinkedList;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int count;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
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
        this.tail = null;
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
            if(this.head != null){
                this.head.prev = newNode;
            }
            this.head = newNode;
        } else if (index == this.count) {
            this.tail.next = newNode;
            newNode.prev = this.tail;
            newNode.next = null;
        } else {
            Node currentNode = this.head;
            for(int i = 0; i < index - 1; ++i) {
                currentNode = currentNode.next;
            }
            newNode.next = currentNode.next;
            currentNode.next.prev = newNode;
            currentNode.next = newNode;
            newNode.prev = currentNode;
        }

        if(newNode.next == null) {
            this.tail = newNode;
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
            if(this.head.next == null) {
                //남은 노드가 1개인 경우
                this.head = null;
                this.tail = null;
            } else {
                //남은 노드가 2개 이상인 경우
                this.head = this.head.next;
                this.head.prev = null;
            }
        } else if(index == this.count - 1) {
            deletedNode = this.tail;
            this.tail = this.tail.prev;
            this.tail.next = null;
        } else {
            Node currentNode = this.head;
            for(int i = 0; i < index - 1; ++i){
                currentNode = currentNode.next;
            }
            deletedNode = currentNode.next;
            currentNode.next = currentNode.next.next;
            currentNode.next.prev = deletedNode.prev;
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
