package QuickSort;

public class QuickSort {
    public static void quick_sort(int[] arr, int left, int right) {
        if(left <= right) {
            int pivot = divide(arr, left, right);
            quick_sort(arr, left, pivot - 1);
            quick_sort(arr, pivot + 1, right);
        }
    }
    public static int divide(int[]arr, int left, int right) {
        int pivot = arr[left];
        int leftIdx = left + 1;
        int rightIdx = right;

        while(leftIdx <= rightIdx) {
            while (leftIdx <= right && pivot >= arr[leftIdx]) ++leftIdx;
            while (rightIdx >= (left + 1) && pivot <= arr[rightIdx]) --rightIdx;

            if (leftIdx <= rightIdx) {
                int tmp = arr[leftIdx];
                arr[leftIdx] = arr[rightIdx];
                arr[rightIdx] = tmp;
            }
        }

        //피벗 <-> rightIdx 자리교환
        arr[left] = arr[rightIdx];
        arr[rightIdx] = pivot;
        return rightIdx;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 9, 4, 5};

        System.out.println("===== 정렬 전 =====");
        for(int x: arr) System.out.printf("%d ", x);
        System.out.println();


        quick_sort(arr, 0, arr.length - 1);
        System.out.println("===== 정렬 후 =====");
        for(int x: arr) System.out.printf("%d ", x);
        System.out.println();
    }
}
