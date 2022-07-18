package coplit.stack_and_queue;

import java.util.ArrayList;

public class PaveBox2 {
    public static void main(String[] args) {

    }
    static int paveBox(Integer[] boxes){
        int count = 1;
        int big = boxes[0];

        ArrayList<Integer> line = new ArrayList<>();

        for (int i=0; i<boxes.length; i++) {
            if(i+1==boxes.length){
                line.add(count);
                break;
            }

            if(big>=boxes[i+1]){
                count++;
            }

            else{ //big<boxes[i+1]
                big = boxes[i+1];
                line.add(count);
                count=1;
                continue;
            }

        }
        return line.stream().max(Integer::compare).orElse(-1);
    }
}
