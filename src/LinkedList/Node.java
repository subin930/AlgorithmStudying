package LinkedList;

public class Node {
    public int data;
    public Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
