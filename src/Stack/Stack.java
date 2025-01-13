package Stack;

import LinkedList.LinkedList;
import LinkedList.Node;

public class Stack {
    public LinkedList list;

    public Stack() {
        list = new LinkedList();
    }

    public void push(int data) throws Exception {
        this.list.insertAt(0, data);
    }

    public Node pop() throws Exception {
        return this.list.deleteAt(0);
    }

    public Node peek() throws Exception {
        return this.list.getNodeAt(0);
    }

    public Boolean isEmpty() {
        return this.list.count == 0;
    }
}
