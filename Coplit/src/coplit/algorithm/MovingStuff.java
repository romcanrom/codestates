package coplit.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MovingStuff {
    public static void main(String[] args) {
/*        int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
        System.out.println(output); // 3

        System.out.println("-".repeat(30));

        int output2 = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
        System.out.println(output2); // 4

        System.out.println("-".repeat(30));

 */

        int output3 = movingStuff(new int[]{42, 25, 60, 73, 103, 167}, 187);
        System.out.println(output3); //4

       /* int output4 = movingStuff(new int[]{60, 73, 80, 87, 103, 109, 119, 123,
                128, 129, 136, 146, 153, 168, 182}, 200);
        System.out.println(output4); //11
        */

    }

    static int movingStuff(int[] stuff, int limit) {
        int box = 0;
        int space = 0;

        Arrays.sort(stuff);
        List<Integer> list = Arrays.stream(stuff).boxed().collect(Collectors.toList());


        while(!list.isEmpty()){

            if(list.size()==1){
                box++;
                list.clear();
                return box;
            }

            space = list.get(list.size()-1);
            System.out.println(list);

            for(int i=0; i<list.size(); i++){

                if(space + list.get(i) <= limit){
                    box++;
                    list.remove(i);
                    list.remove(list.size()-1);
                    break;
                }
                else{
                    box++;
                    list.remove(list.size()-1);
                    break;
                }
            }
        }

        return box;
    }
}
