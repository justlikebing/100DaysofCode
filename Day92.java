public class Day92 {
    public static void mergeSortInRange(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;

            mergeSortInRange(arr, l, mid);

            mergeSortInRange(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

    
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i) {
            left[i] = arr[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            right[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 13, 4, 1, 3, 6, 28};
        int l = 0;
        int r = arr.length - 1;

        mergeSortInRange(arr, l, r);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
