package coplit.daily;

import java.util.ArrayList;
import java.util.List;

public class SuperIncreasing {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 8, 15};
        System.out.println(superIncreasing(arr));
    }
    static boolean superIncreasing(int[] arr){
        List<Integer> list = new ArrayList<>(arr.length);
        list.add(arr[0]);

        for(int i=1; i<arr.length; i++){
            int sum = list.stream().reduce(0, Integer::sum);
            if(sum >= arr[i]) return false;
            else list.add(arr[i]);
        }

        return true;
    }
}
