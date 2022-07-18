package coplit.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BoardGame {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };
        System.out.println(solution.boardGame(board1, "RRDLLD")); // 4
    }


}

class Solution {
    public Integer boardGame(int[][] board, String operation) {
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < operation.length(); i++) queue.add(operation.substring(i, i + 1));

        Integer score = 0;
        int nowCol=0;
        int nowRow=0;

        while (!queue.isEmpty()) {
            String now = queue.poll();
            System.out.println(now);

            switch (now) {
                case "U":
                    nowRow--; break;
                case "D":
                    nowRow++; break;
                case "L":
                    nowCol--; break;
                case "R":
                    nowCol++; break;
            }

            if (nowRow < 0 || nowCol < 0) return null;
            else score += board[nowRow][nowCol];

        }

        return score;


    }

}
