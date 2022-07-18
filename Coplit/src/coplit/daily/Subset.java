package coplit.daily;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Subset {
    public static void main(String[] args) {
        int[] base = new int[]{1, 2, 3, 4, 5};
        int[] sample = new int[]{1, 3};
        boolean output = isSubsetOf(base, sample);
        System.out.println(output); // --> true

        sample = new int[]{6, 7};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

        base = new int[]{10, 99, 123, 7};
        sample = new int[]{11, 100, 99, 123};
        output = isSubsetOf(base, sample);
        System.out.println(output); // --> false

    }
    public static boolean isSubsetOf(int[] base, int[] sample) {
        Arrays.sort(base);
        Arrays.sort(sample);


        for (int s : sample) {
            boolean check = false;
            for (int b : base) {
                if (s == b) {
                    check = true;
                    break;
                }
            }
            if (!check) return false;
        }

        return true;
    }

    public boolean solution(int[] base, int[] sample) {
        List<Integer> list = Arrays.stream(base)
                .boxed().collect(Collectors.toList());

        for(int s : sample) {
            if(!list.contains(s)) return false;
        }

        return true;
    }
}
