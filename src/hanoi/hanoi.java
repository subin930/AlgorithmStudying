package hanoi;

public class hanoi {
    public static void hanoi_func(int count, String from, String to, String temp) {
        if(count == 0) return;
        hanoi_func(count - 1, from, temp, to);
        System.out.printf("원반 %d를 %s에서 %s로 이동\n", count, from, to);
        hanoi_func(count - 1, temp, to, from);
    }
    public static void main(String[] args) {
        hanoi_func(3, "A", "C", "B");
    }
}
