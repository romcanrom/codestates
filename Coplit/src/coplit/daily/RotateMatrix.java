package coplit.daily;

public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int K = 1;

        System.out.println(matrix[0][0]); // --> 1
        System.out.println(matrix[3][2]); // --> 15

        int[][] rotatedMatrix = rotateMatrix(matrix, K);
        System.out.println(rotatedMatrix[0][0]); // --> 13
        System.out.println(rotatedMatrix[3][2]); // --> 8

    }

    //N X N
    public static int[][] rotateMatrix(int[][] matrix, int K) {
        if (matrix == null) return null;
        if (K % 4 == 0) return matrix;

        int maxIndex = matrix.length - 1;
        int minIndex = 0;

        int len = matrix.length;
        int[][] result = new int[len][len];

        if (K % 4 == 1) {
            while (minIndex < len) {
                for (int i = 0; i < len; i++) {
                    result[i][maxIndex] = matrix[minIndex][i];
                }
                maxIndex--;
                minIndex++;
            }
        } else if (K % 4 == 2) {
            while (minIndex < len) {
                for (int i = 0, j = maxIndex; i < len; i++, j--) {
                    result[maxIndex][j] = matrix[minIndex][i];
                }
                maxIndex--;
                minIndex++;
            }
        } else if (K % 4 == 3) {
            while (minIndex < len) {
                for (int i = 0, j = maxIndex; i < len; i++, j--) {
                    result[j][minIndex] = matrix[minIndex][i];
                }
                minIndex++;
            }
        }

        return result;
    }



}
