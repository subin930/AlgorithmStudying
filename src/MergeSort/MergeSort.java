package MergeSort;

public class MergeSort {
    public static void merge_sort(int[] arr, int leftIdx, int rightIdx)  {
        if(leftIdx < rightIdx) {
            int midIdx = (leftIdx + rightIdx) / 2;
            merge_sort(arr, leftIdx, midIdx);
            merge_sort(arr, midIdx + 1, rightIdx);
            merge(arr, leftIdx, midIdx, rightIdx);
        }
    }
    public static void merge(int[] arr, int leftIdx, int midIdx, int rightIdx) {
        int[] arr_copy = new int[rightIdx - leftIdx + 1];
        int leftAreaIdx = leftIdx;
        int rightAreaIdx = midIdx + 1;
        int i = 0;

        while(leftAreaIdx <= midIdx && rightAreaIdx <= rightIdx) {
            if(arr[leftAreaIdx] <= arr[rightAreaIdx]) {
                arr_copy[i++] = arr[leftAreaIdx++];
            } else {
                arr_copy[i++] = arr[rightAreaIdx++];
            }
        }

        while (leftAreaIdx <= midIdx) {
            arr_copy[i++] = arr[leftAreaIdx++];
        }

        while (rightAreaIdx <= rightIdx) {
            arr_copy[i++] = arr[rightAreaIdx++];
        }

        for (int j = 0; j < arr_copy.length; j++) {
            arr[leftIdx + j] = arr_copy[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 4, 5};

        System.out.println("===== 정렬 전 =====");
        for (int x : arr) System.out.printf("%d ", x);
        System.out.println();

        merge_sort(arr, 0, arr.length - 1);

        System.out.println("===== 정렬 후 =====");
        for (int x : arr) System.out.printf("%d ", x);
        System.out.println();
    }
}
