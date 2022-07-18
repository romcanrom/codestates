package coplit.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class RockScissorsPaper {
    public static void main(String[] args) {

        RockScissorsPaper r = new RockScissorsPaper();

        ArrayList<String[]> output = r.rockScissorsPaper(5);
        System.out.println(output.size());
        for(String[] s : output) System.out.println(Arrays.deepToString(s));

    }

    public ArrayList<String[]> rockScissorsPaper(int rounds){
        ArrayList<String[]> outcomes = new ArrayList<>();
        return permutation(rounds, new String[]{}, outcomes);
    }


    public ArrayList<String[]> permutation(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes){
        //base case
        if(roundsToGo==0){
            outcomes.add(playedSoFar);
            return outcomes;
        }

        String[] rps = new String[]{"rock", "paper", "scissors"};

        for(int i=0; i<rps.length; i++){
            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length+1);
            concatArray[concatArray.length-1] = rps[i];
            permutation(roundsToGo-1, concatArray, outcomes);
        }
        return outcomes;
    }
}
