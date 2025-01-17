package HashSet;
import HashTable.HashTable;
import HashTable.Node;

import java.util.Iterator;


public class HashSet {
    HashTable hashTable;
    public HashSet() {
        this.hashTable = new HashTable(10);
    }

    public void add(int data) {
        if(this.hashTable.get(data) == null) {
            this.hashTable.set(data, "0");
        }
    }

    public Boolean isContain(int data) {
        return this.hashTable.get(data) != null;
    }

    public Node remove(int data) {
        return this.hashTable.remove(data);
    }

    public void clear() {
        for(int i = 0; i < hashTable.size; ++i) {
            this.hashTable.arr[i].clear();
        }
    }

    public Boolean isEmpty() {
        boolean isEmpty = true;
        for(int i = 0; i < hashTable.size; ++i) {
            if(!this.hashTable.arr[i].isEmpty()) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    public void printAll() {
        for(int i = 0; i < hashTable.size; ++i) {
            Iterator<Node> it = this.hashTable.arr[i].iterator();
            System.out.printf("===== Hash %d =====\n", i);
            while(it.hasNext()) {
                System.out.printf(String.valueOf(it.next().key) + " ");
            }
            System.out.println();
        }
    }
}
