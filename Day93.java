import java.util.Arrays;

public class Day93 {
    public static int[] alternatePositiveNegative(int[] A, int N) {
        int[] result = new int[N];
        int positiveIndex = 0;
        int negativeIndex = 0;

        while (positiveIndex < N && A[positiveIndex] < 0) {
            positiveIndex++;
        }
        while (negativeIndex < N && A[negativeIndex] > 0) {
            negativeIndex++;
        }

        int i = 0;
        while (i < N && positiveIndex < N && negativeIndex < N) {
            if (i % 2 == 0) {
                result[i++] = A[positiveIndex++];
            } else {
                result[i++] = A[negativeIndex++];
            }
        }

        while (positiveIndex < N) {
            result[i++] = A[positiveIndex++];
        }

        while (negativeIndex < N) {
            result[i++] = A[negativeIndex++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, -4, -5};
        int N = 4;

        int[] result = alternatePositiveNegative(A, N);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
