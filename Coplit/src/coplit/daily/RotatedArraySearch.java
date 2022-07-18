package coplit.daily;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RotatedArraySearch {
    public static void main(String[] args) {
        int output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 2);
        System.out.println(output); // --> 5

        output = rotatedArraySearch(new int[]{4, 5, 6, 0, 1, 2, 3}, 100);
        System.out.println(output); // --> -1
    }

    public static int rotatedArraySearch(int[] rotated, int target) {
        List<Integer> sorted = Arrays.stream(rotated)
                .boxed().collect(Collectors.toList());

        int min = sorted.stream().reduce(0, Integer::min);
        int max = sorted.stream().reduce(0, Integer::max);
        if(target < min || target > max) return -1;

        else return sorted.indexOf(target);
    }
}
