package coplit.daily;

import java.util.ArrayList;
import java.util.List;

public class Tiling {
    public static void main(String[] args) {
        int output = tiling(2);
        System.out.println(output); // --> 2

        output = tiling(4);
        System.out.println(output); // --> 5
    }

    public static int tiling(int num) {
        ArrayList<Integer> memo = new ArrayList<>(List.of(0, 1, 2));
        return cal(num, memo);
    }

    public static int cal(int size, ArrayList<Integer> memo) {
        if(memo.size() > size) return memo.get(size);
        memo.add(cal(size - 1, memo) + cal(size - 2, memo));
        return memo.get(size);
    }
}
