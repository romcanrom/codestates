package coplit.algorithm;

public class Ocean {
    public static void main(String[] args) {
       // System.out.println(ocean(50, new int[]{10, 20, 50}));
        System.out.println(ocean(100, new int[]{10, 20, 50}));
        //System.out.println(ocean(30, new int[]{5, 6, 7}));
    }

    static long ocean(int target, int[] type) {
        //long : target의 입력 범위(~10만) 고려
        //1부터 target까지 계산하기 위한 배열 선언
        long[] bag = new long[target + 1];

        bag[0] = 1;

        //배열 순회
        for (int i = 0; i < type.length; i++) {

            //1부터 target에 도달할 때까지 반복
            for (int j = 1; j <= target; j++) {
                //입력받은 type 배열의 요소가 얻어야 하는 target 보다 작거나 같을때 실행
                if (type[i] <= j){
                    bag[j] += bag[j - type[i]];
                    System.out.printf("bag[%d] = %d\n", j, bag[j]);
                }
            }
            System.out.println("-".repeat(30));
        }
        return bag[target];
    }
}
