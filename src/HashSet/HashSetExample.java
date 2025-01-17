package HashSet;

public class HashSetExample {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();

        System.out.println(hashSet.isEmpty());
        System.out.println();

        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(123);
        hashSet.add(223);
        hashSet.add(512);
        hashSet.printAll();
        System.out.println(hashSet.isEmpty());
        System.out.println();

        System.out.println(hashSet.isContain(1));
        hashSet.remove(1);
        System.out.println(hashSet.isContain(1));
        System.out.println();

    }
}
