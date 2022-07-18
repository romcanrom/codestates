package coplit.daily;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] output = b.bubbleSort(new int[]{2, 1, 3, 7, 2, 9});
        System.out.println(Arrays.toString(output));
    }

    public int[] bubbleSort(int[] arr) {
        int end = arr.length - 1;
        while (end > 0) {
            int last = 0;
            for (int i = 0; i < end; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                    last = i;
                }
            }
            end = last;
        }

        return arr;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
