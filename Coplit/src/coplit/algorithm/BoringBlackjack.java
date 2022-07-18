package coplit.algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BoringBlackjack {
    public static void main(String[] args) {
        int[] cards = new int[]{1, 2, 3, 4};

        BoringBlackjack b = new BoringBlackjack();
        System.out.println(b.boringBlackjack(cards));

    }
    public int boringBlackjack(int[] cards){
        int ways = 0;

        boolean[] visited = new boolean[cards.length];
        List<Integer> result = new LinkedList<>();

        List<Integer> newNums = findingNums(cards, visited, 0, cards.length, 3, result);


        while(!newNums.isEmpty()){
            boolean flag = true;
            int num = newNums.remove(0);

            for(int i=2; i<num; i++){
                if(num % i == 0) flag=false;
            }
            if(flag) ways++;
        }

        return ways;

    }

    public  List<Integer> findingNums(int[] cards, boolean[] visited,
                                      int depth, int max, int count, List<Integer> result){

        int sum = 0;
        if(count==0){
            for(int i=0; i<max; i++){
                if(visited[i]) sum+=cards[i];
            }
            result.add(sum);
            return result;
        }

        if(depth==cards.length){
            return result;
        }

        visited[depth] = true; //선택
        findingNums(cards, visited, depth+1, max, count-1, result);

        visited[depth] = false; //선택X
        findingNums(cards, visited, depth+1, max, count, result);


        return result;
    }


}
