package coplit.daily;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OrderOfPresentation {
    static ArrayList<Integer> numbers = new ArrayList<>();
    static boolean[] visited;
    static ArrayList<int[]> result = new ArrayList<>();


    public static void main(String[] args) {
        int answer = orderOfPresentation(3, new int[]{1, 2, 3});

        System.out.println(answer);
    }

    public static int orderOfPresentation(int N, int[] K) {
        for (int i = 0; i < N; i++) {
            numbers.add(i + 1);
        }
        visited = new boolean[numbers.size()];

        ArrayList<int[]> result = findOrders(new int[]{}, 0, N);

        ArrayList<int[]> may = new ArrayList<>();
        result.stream().filter(r -> Arrays.deepEquals(Arrays.stream(r).boxed().toArray(),
                        Arrays.stream(K).boxed().toArray()))
                .forEach(may::add);


        for (int i = 0; i < may.size(); i++) {
            boolean flag = true;
            for (int j = 0; j < K.length; j++) {
                if(K[j] != may.get(i)[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag) return result.indexOf(may.get(i));
        }

        return -1;
    }

    public static ArrayList<int[]> findOrders(int[] order, int depth, int N) {
        if (depth == N) {
            result.add(order);
            return result;
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;

                int[] addOrder = Arrays.copyOf(order, order.length + 1);
                addOrder[addOrder.length - 1] = numbers.get(i);

                findOrders(addOrder, depth + 1, N);

                visited[i] = false;
            }
        }

        return result;
    }
}
