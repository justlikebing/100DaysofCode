public class Day91 {
    public static void recursiveInsertionSort(int[] arr, int n) {
        if (n <= 1) {
            return;
        }

        recursiveInsertionSort(arr, n - 1);

        int key = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }

    public static void main(String[] args) {
        int N = 7;
        int[] arr = {2, 13, 4, 1, 3, 6, 28};

        recursiveInsertionSort(arr, N);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

