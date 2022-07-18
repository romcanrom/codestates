package coplit.daily;

import java.util.ArrayList;
import java.util.Collections;

public class PowerSet {
    public static void main(String[] args) {
        ArrayList<String> output1 = powerSet("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output2 = powerSet("jump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]
    }

    public static ArrayList<String> powerSet(String str) {
        char[] arr = str.toCharArray();
        ArrayList<String> result = new ArrayList<>();
        int len = arr.length;
        boolean[] visited = new boolean[len];

        result = search(arr, visited, len, 0, result);
        Collections.sort(result);

        return result;
    }

    public static ArrayList<String> search(char[] arr, boolean[] visited, int len, int depth, ArrayList<String> result) {
        StringBuilder element = new StringBuilder();

        if (len == depth) {
            for (int i = 0; i < len; i++) {
                if(visited[i]) element.append(arr[i]);
            }
            result.add(String.valueOf(element));
            return result;
        }

        visited[depth] = false;
        search(arr, visited, len, depth + 1, result);
        visited[depth] = true;
        search(arr, visited, len, depth + 1, result);

        return result;
    }
}
