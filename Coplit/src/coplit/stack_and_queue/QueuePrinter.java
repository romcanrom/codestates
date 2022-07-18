package coplit.stack_and_queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueuePrinter {
    public static void main(String[] args) {
        Queue<Integer> list = new LinkedList<>();
        list.add(7);
       //System.out.println(list.stream().mapToInt(i->i).sum());
       //System.out.println(list.size());
        int bufferSize = 2;
        int capacities = 10;
        int[] documents = new int[]{7, 4, 5, 6};

        System.out.println(printer(bufferSize, capacities, documents));
    }
    static int queuePrinter(int bufferSize, int capacities, int[] documents) {

        Queue<Integer> list = new LinkedList<>();
        Queue<Integer> waitList = new LinkedList<>();

        for(int i=0; i<documents.length; i++){
            waitList.add(documents[i]);
        }

        int time = 0;

        while(!waitList.isEmpty()) {
            int listSize = list.stream().mapToInt(p->p).sum() + waitList.peek();

            //bufferSize 자리 있는 경우
            if (list.size() < bufferSize) {
                //capacities 초과하지 않는다면
                if(listSize <= capacities){
                    list.add(waitList.poll());
                }
                //capacities 초과한다면
                else if(listSize > capacities){
                    list.add(0);
                }
            }

            //bufferSize 꽉 찬 경우
            else {
                //하나 출력 (버리기) -> list.size() == bufferSize-1
                list.poll();
                //앞의 요소가 출력된 이후 다시 sum 계산
                listSize = list.stream().mapToInt(p->p).sum() + waitList.peek();

                //출력 테스트
                System.out.println("-"+list);

                //capacities 초과하지 않는다면 -> 값 넣을 수 있음
                if(listSize <= capacities){
                    list.add(waitList.poll());
                }
                //capacities 초과한다면 -> 값 못 넣음
                else if(listSize > capacities){
                    list.add(0);
                }
            }

            //출력 테스트
            System.out.println(list);

            time++;
        }


        /* 출력 확인
        System.out.println(list.size());
        System.out.println(list);
        */

        //waitList의 마지막 요소를 list에 올리는 데서 끝났으므로
        //bufferSize만큼 시간이 지나야 마지막 요소가 출력된다
        time+=bufferSize;


        return time;

    }
    static int printer(int bufferSize, int capacities, int[] documents){
        // TODO:
        int time = 0;
        //Queue생성
        Queue<Integer> qPrint = new LinkedList<Integer>();

        int Qsize = qPrint.stream().mapToInt(m->m).sum();

        //배열 넣는 방법 고민하기
        Queue<Integer> qDoc = new LinkedList<>();
        for(int n : documents){
            qDoc.offer(n);
        }
        //버퍼사이즈만한 Q
        for(int i = 0; i<bufferSize; i++){
            qPrint.offer(0);
        }

        //파일을 추가하고 남은 사이즈 보다 다음 파일의 사이즈가 작다면 다음에 추가 가능(버퍼사이즈까지만)
        //공간이 남지 않으면 기존에 추가된 파일은 한칸 이동 시간+

        while(!qDoc.isEmpty()){
            qPrint.poll();
            if(Qsize + qDoc.peek()>= capacities){
                qPrint.offer(qDoc.poll());
            }else{
                qPrint.offer(0);
            }
            time++;
        }

        time += bufferSize;
        return time;
    }
}

