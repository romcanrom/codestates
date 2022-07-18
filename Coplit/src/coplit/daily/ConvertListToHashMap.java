package coplit.daily;

import java.util.HashMap;

public class ConvertListToHashMap {
    public static void main(String[] args) {
        String[][] arr = new String[][]{
                {"make", "Ford"},
                {"model", "Mustang"},
                {"year", "1964"},
                {"make", "Bill"}
        };

        System.out.println(convertListToHashMap(arr));

    }

    static HashMap<String, String> convertListToHashMap(String[][] arr) {
        HashMap<String, String> result = new HashMap<>();

        if (arr.length == 0) return result;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length == 0) break;
            result.put(arr[i][0], result.getOrDefault(arr[i][0], arr[i][1]));
        }

        return result;
    }
}
