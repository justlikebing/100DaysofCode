import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> maxHeap; // Max heap for the smaller half
    PriorityQueue<Integer> minHeap; // Min heap for the larger half

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.offer(num); // Add to max heap

        minHeap.offer(maxHeap.poll()); // Move the maximum of max heap to min heap

        // Balance the sizes of max and min heaps
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            // If the size is even, return the average of the two middle elements
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            // If the size is odd, return the middle element
            return maxHeap.peek();
        }
    }
}

public class Day45 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // Output: 2.0
    }
}
