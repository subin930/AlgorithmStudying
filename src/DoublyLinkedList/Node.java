package DoublyLinkedList;

public class Node {
    public int data;
    public Node next;
    public Node prev;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
