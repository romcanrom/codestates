package coplit.daily;

import java.util.Arrays;

public class ReadVertically {
    public static void main(String[] args) {
        String[] input = new String[]{
                "hello",
                "world",
        };
        String output = readVertically(input);
        System.out.println(output); // --> "hweolrllod"

        input = new String[]{
                "hi",
                "world",
        };
        output = readVertically(input);
        System.out.println(output); // --> "hwiorld"

    }

    static String readVertically(String[] arr) {
        StringBuilder sb = new StringBuilder();
        int maxLen = Arrays.stream(arr).mapToInt(String::length).max().getAsInt();

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j].length()) continue;
                sb.append(arr[j].charAt(i));
            }
        }

        return String.valueOf(sb);
    }
}
