package coplit.algorithm;

public class PartTimeJob {
    public static void main(String[] args) {
        int output1 = partTimeJob(4000);
        System.out.println(output1); // --> 8

        int output2 = partTimeJob(4972);
        System.out.println(output2); // --> 18
    }

    static int partTimeJob(int k) {
        //1, 5, 50, 100, 500

        int[] coins = {500, 100, 50, 10, 5, 1};
        int count = 0;

        for (int i = 0; i < coins.length; i++) {
            count += k / coins[i];
            k = k % coins[i];
        }
        return count;
    }
}
