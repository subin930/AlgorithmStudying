package Queue;
import DoublyLinkedList.DoublyLinkedList;
import DoublyLinkedList.Node;

public class Queue {
    public DoublyLinkedList list;

    public Queue() {
        list = new DoublyLinkedList();
    }

    public void enqueue(int data) throws Exception {
        this.list.insertAt(0, data);
    }

    public Node dequeue() throws Exception {
        return this.list.deleteLast();
    }

    public Node front() throws Exception{
        return this.list.getNodeAt(this.list.count - 1);
    }
}
