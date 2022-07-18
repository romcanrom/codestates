package coplit.algorithm;

import java.util.*;

public class NewChickenRecipe {
    public static void main(String[] args) {

        NewChickenRecipe n = new NewChickenRecipe();

        ArrayList<Integer[]> output1 = n.newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        for(Integer[] i : output1) System.out.println(Arrays.deepToString(i));
        //System.out.println(output1);

    }
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum){
        Arrays.sort(stuffArr);
        ArrayList<Integer[]> result = new ArrayList<>();
        ArrayList<Integer> fresh = new ArrayList<>();

        //0이 3개 이상인 경우 제외하기
        for(int i=0; i<stuffArr.length; i++){
            if(stuffArr[i] < 1000) {
                fresh.add(stuffArr[i]);
                continue;
            }
            int test = stuffArr[i];
            int count = 0;
            while(test > 0){
                if(test%10==0) count++;
                test/=10;
            }
            if(count<3) fresh.add(stuffArr[i]);
        }

        if(fresh.isEmpty() || fresh.size()<choiceNum) return null;

        boolean[] visited = new boolean[fresh.size()];


        return recipeCount(fresh, choiceNum, visited, 0, new Integer[]{}, result);
    }

    public ArrayList<Integer[]> recipeCount(ArrayList<Integer> fresh, int choiceNum, boolean[] visited,
                                            int depth, Integer[] recipes, ArrayList<Integer[]> result){

        if(depth==choiceNum){
            result.add(recipes);
            return result;
        }

        for(int i=0; i<fresh.size(); i++){
            if(!visited[i]){
                visited[i] = true;

                Integer[] concatArray = Arrays.copyOf(recipes, recipes.length + 1);
                concatArray[concatArray.length-1] = fresh.get(i);

                recipeCount(fresh, choiceNum, visited, depth+1, concatArray, result);
                visited[i]=false;
            }
        }

        return result;
    }
}
