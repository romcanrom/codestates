package coplit.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class DivideStick {
    public static void main(String[] args) {
        int m = 4;
        int n = 8;
        DivideStick d = new DivideStick();
        ArrayList<Integer[]> result =d.divideChocolateStick(20, 10);
        for(Integer[] i : result) System.out.println(Arrays.deepToString(i));

        System.out.println("-".repeat(30));
        System.out.println(d.gcd(12, 15));
    }


    public ArrayList<Integer[]> divideChocolateStick(int M, int N){
        int gcd = findingGcd(M, N);
        ArrayList<Integer[]> result = new ArrayList<>();

        for(int i=1; i<=gcd; i++){
            if(gcd%i==0) result.add(new Integer[]{i, M/i, N/i});
        }

        return result;
    }

    public int findingGcd(int M, int N){
        if(N==0) return M;
        return findingGcd(N, M % N);
    }
    public int gcd(int M, int N){
        System.out.printf("gcd(%d, %d)\n", N, M%N);
        if(M%N == 0) return N;
        return gcd(N, M%N);
    }

}
