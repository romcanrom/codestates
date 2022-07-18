package coplit.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) {
        int output = fibonacci(0);
        System.out.println(output); // --> 0

        output = fibonacci(1);
        System.out.println(output); // --> 1

        output = fibonacci(5);
        System.out.println(output); // --> 5

        output = fibonacci(9);
        System.out.println(output); // --> 34
    }

    public static int fibonacci(int num) {
        if(num<=1) return num;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);

        return cal(list, num);
    }

    public static int cal(ArrayList<Integer> list, int num) {
        if(list.size() <= num) {
            list.add(cal(list, num-1) + cal(list, num-2));
        }

        return list.get(num);
    }
}
