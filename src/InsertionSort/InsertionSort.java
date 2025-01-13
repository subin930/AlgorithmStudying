package InsertionSort;

public class InsertionSort {
    public static int[] insertion_sort(int[] arr) {
        for(int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > tmp) {
                arr[j + 1] = arr[j];
                --j;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 4, 5};

        System.out.println("===== 정렬 전 =====");
        for(int x: arr) System.out.printf("%d ", x);
        System.out.println();


        int[] arr_sorted = insertion_sort(arr);
        System.out.println("===== 정렬 후 =====");
        for(int x: arr_sorted) System.out.printf("%d ", x);
        System.out.println();
    }
}
