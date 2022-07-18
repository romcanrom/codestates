package coplit.review;

import java.util.ArrayList;
import java.util.Arrays;

public class RockPaperScissors {
    public static void main(String[] args) {
        RockPaperScissors r = new RockPaperScissors();
        ArrayList<String[]> rps = r.rockPaperScissors(5);
        for(String[] s : rps) System.out.println(Arrays.deepToString(s));
    }
    public ArrayList<String[]> rockPaperScissors(int rounds){
        ArrayList<String[]> result = new ArrayList<>();
        String[] rps= {"rock", "paper", "scissors"};
        return permutation(rps, rounds, new String[]{}, result);
    }

    public ArrayList<String[]> permutation(String[] rps, int rounds,
                                           String[] now, ArrayList<String[]> result){
        //base case
        if(rounds==0) {
            result.add(now);
            return result;
        }

        //recursion case
        for(int i=0; i<rps.length; i++){
            String[] ways = Arrays.copyOf(now, now.length+1);
            ways[ways.length-1] = rps[i];
            permutation(rps, rounds-1, ways, result);
        }
        return result;
    }
}
