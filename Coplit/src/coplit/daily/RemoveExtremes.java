package coplit.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveExtremes {
    public static void main(String[] args) {
        String[] output = removeExtremes(new String[]{"a", "b", "c", "def"});
        System.out.println(Arrays.toString(output)); // --> ["a"', "b"]

        output = removeExtremes(new String[]{"where", "is", "the", "longest", "word"});
        System.out.println(Arrays.toString(output)); // --> ["where", "the", "word"]

    }
    static String[] removeExtremes(String[] arr){
        if(arr.length==0) return null;

        List<String> list = new ArrayList<>(Arrays.asList(arr));

        String minStr = list.get(list.size()-1);
        String maxStr = list.get(list.size()-1);

        for(int i=list.size()-1; i>0; i--){
            if(list.get(i-1).length() > maxStr.length()) maxStr = list.get(i-1);
            if(list.get(i-1).length() < minStr.length()) minStr = list.get(i-1);
        }

        list.remove(minStr);
        list.remove(maxStr);

        return list.toArray(new String[list.size()]);
    }
}
