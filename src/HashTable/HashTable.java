package HashTable;

import java.util.Iterator;
import java.util.LinkedList;

class Node {
    int key;
    String value;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
public class HashTable {
    private LinkedList<Node>[] arr;
    private int size;

    public HashTable(int size) {
        this.size = size;
        this.arr = new LinkedList[size];
        for(int i = 0; i < size; ++i) {
            arr[i] = new LinkedList<>();
        }
    }

    public int hashFunction(int number) {
        return number % size;
    }

    public void set(int key, String value) {
        this.arr[hashFunction(key)].add(new Node(key, value));
    }

    public Node get(int key) {
        Iterator<Node> it = this.arr[hashFunction(key)].iterator();
        while(it.hasNext()) {
            Node node = it.next();
            if(node.key == key) return node;
        }
        return null;
    }

    public Node remove(int key) {
        Iterator<Node> it = this.arr[hashFunction(key)].iterator();
        while(it.hasNext()) {
            Node node = it.next();
            if(node.key == key) {
                arr[hashFunction(key)].remove(node);
                return node;
            }
        }
        return null;
    }
}
