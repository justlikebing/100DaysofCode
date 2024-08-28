import java.util.*;

public class Day64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        zeroMatrix(matrix);


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void zeroMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int j = 0; j < M; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < M; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < M; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < N; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < M; j++) {
                matrix[0][j] = 0;
            }
        }


        if (firstColHasZero) {
            for (int i = 0; i < N; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
