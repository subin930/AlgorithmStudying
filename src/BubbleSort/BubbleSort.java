package BubbleSort;

public class BubbleSort {
    public static int[] bubble_sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            for(int j = 0; j < arr.length - 1 - i; ++j) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 4, 5};

        System.out.println("===== 정렬 전 =====");
        for(int x: arr) System.out.printf("%d ", x);
        System.out.println();


        int[] arr_sorted = bubble_sort(arr);
        System.out.println("===== 정렬 후 =====");
        for(int x: arr_sorted) System.out.printf("%d ", x);
        System.out.println();
    }
}
