package coplit.daily;

import java.util.Arrays;

public class LargestProductOfThree {
    public static void main(String[] args) {
        int output = largestProductOfThree(new int[]{2, 1, 3, 7});
        System.out.println(output); // --> 42 (= 2 * 3 * 7)

        output = largestProductOfThree(new int[]{-1, 2, -5, 7});
        System.out.println(output); // --> 35 (= -1 * -5 * 7)
    }
    static int largestProductOfThree(int[] arr) {
        Arrays.sort(arr);
        int result1 = arr[0] * arr[1] * arr[arr.length-1];
        int result2 = arr[arr.length-1] * arr[arr.length-2] * arr[arr.length-3];

        return Math.max(result1, result2);
    }

}
