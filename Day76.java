import java.util.*;

public class Day76 {

    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int x) {
        heap.add(x);
        int index = heap.size() - 1;
        heapifyUp(index);
    }

    public int removeMin() {
        if (heap.isEmpty()) {
            return -1; // No elements in the heap
        }
        int min = heap.get(0);
        int lastElement = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
        return min;
    }

    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        while (index > 0 && heap.get(parentIndex) > heap.get(index)) {
            Collections.swap(heap, parentIndex, index);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    private void heapifyDown(int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int smallestIndex = index;
        if (leftChildIndex < heap.size() && heap.get(leftChildIndex) < heap.get(smallestIndex)) {
            smallestIndex = leftChildIndex;
        }
        if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(smallestIndex)) {
            smallestIndex = rightChildIndex;
        }
        if (smallestIndex != index) {
            Collections.swap(heap, index, smallestIndex);
            heapifyDown(smallestIndex);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        while (t-- > 0) {
            MinHeap minHeap = new MinHeap();
            int n = scanner.nextInt(); // Number of queries
            while (n-- > 0) {
                int queryType = scanner.nextInt();
                if (queryType == 0) {
                    int x = scanner.nextInt();
                    minHeap.insert(x);
                } else if (queryType == 1) {
                    int min = minHeap.removeMin();
                    System.out.println(min);
                }
            }
        }
        scanner.close();
    }
}
