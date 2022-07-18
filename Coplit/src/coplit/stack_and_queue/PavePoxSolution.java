package coplit.stack_and_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PavePoxSolution {

    public int paveBox(Integer[] boxes){

        //return 할 변수(최대 인원)
        ArrayList<Integer> result = new ArrayList<>();
            //List에 담는다. 한번에 나가는 갯수를 정렬 [1, 2, 5, .. ]
        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(boxes));
        //현재 박스를 순회해야 한다 -> 리스트로 변환 (박스 배열이 담긴 리스트)
        //*****선언을 굳이 List로 하는 이유는? subList를 사용하기ㅏ 위해서

        //반복 기준은? 남아 있는 박스가 없어질 때까지 -> 박스가 없어질 때까지
        while(!arrayList.isEmpty()){
            //박스의 내용을 모두 확인(앞vs.뒤) 박스 다시 순회
            for(int i = 0; i< arrayList.size(); i++){
                //1. 뒤의 박스가 더 큰 경우
                if(arrayList.get(i) > arrayList.get(0)){
                    result.add(i); //???? 앞과 뒤를 비교하는 대상 꼭 확인하기
                    arrayList = arrayList.subList(i, arrayList.size()); //나간 박스 삭제하기
                    break;
                }
                //2. 모든 박스가 더 작을 경우
                if(i== arrayList.size()-1){ //
                    result.add(arrayList.size());
                    arrayList.clear();
                }
            }

        }
        //나가는 박스의 개수가 담긴 리스트에서 가장 큰 수를 반환
        return result.stream().max(Integer::compare).orElse(-1);

    }

}
