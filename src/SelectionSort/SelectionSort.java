package SelectionSort;

import java.util.*;

public class SelectionSort {
    public static int[] selection_sort(int[] arr) {
        for(int i = 0; i < arr.length - 1; ++i) {
            int minIdx = i;
            int min = arr[i];

            for(int j = i + 1; j < arr.length; ++j) {
                if(min > arr[j]) {
                    minIdx = j;
                    min = arr[j];
                }
            }

            int tmp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = tmp;
        }

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 4, 5};

        System.out.println("===== 정렬 전 =====");
        for(int x: arr) System.out.printf("%d ", x);
        System.out.println();


        int[] arr_sorted = selection_sort(arr);
        System.out.println("===== 정렬 후 =====");
        for(int x: arr_sorted) System.out.printf("%d ", x);
        System.out.println();
    }

}
