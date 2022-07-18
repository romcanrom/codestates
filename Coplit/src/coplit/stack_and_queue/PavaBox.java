package coplit.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class PavaBox {
    public static void main(String[] args) {
        Integer[] boxes2 = new Integer[]{5, 1, 4, 6};
        Integer[] boxes = new Integer[]{6, 10, 1, 11, 7, 3};
        //4
        System.out.println(paveBox(boxes));

    }
    static int paveBox(Integer[] boxes){
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i<boxes.length; i++){
            queue.add(boxes[i]);
        }
        System.out.println(queue);

        int maxCount = 0;
        int tempCount = 1;
        Integer maxNum = queue.peek();
        queue.poll();

        while(queue.size()!=0){
            if(maxNum>queue.peek()){
                tempCount++;
                queue.poll();
                if(tempCount > maxCount) maxCount = tempCount;
            }
            if(maxNum<queue.peek()){
                maxNum = queue.peek();
                queue.poll();
            }
        }
        return maxCount;
    }

}
