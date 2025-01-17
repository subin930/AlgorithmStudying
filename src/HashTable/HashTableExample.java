package HashTable;

public class HashTableExample {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        hashTable.set(1, "이운재");
        hashTable.set(3, "최진철");
        hashTable.set(20, "홍명보");
        hashTable.set(6, "유상철");
        hashTable.set(22, "송종국");
        hashTable.set(21, "박지성");
        hashTable.set(5, "김남일");
        hashTable.set(10, "이영표");
        hashTable.set(8, "최태욱");
        hashTable.set(9, "설기현");

        System.out.println(hashTable.get(9).key);
    }
}
