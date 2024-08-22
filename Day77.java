import java.util.*;

public class Day77 {

    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
    }

    public void enqueue(int element) {
        if (rear == capacity - 1) {
            System.out.println("Queue Overflow");
            return;
        }
        queue[++rear] = element;
    }

    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow");
            return -1;
        }
        int element = queue[front++];
        return element;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int queries = scanner.nextInt(); 
        QueueUsingArray queue = new QueueUsingArray(queries);
        List<Integer> result = new ArrayList<>();
        while (queries-- > 0) {
            int type = scanner.nextInt(); // Query type
            if (type == 1) {
                int element = scanner.nextInt(); // Element to enqueue
                queue.enqueue(element);
            } else if (type == 2) {
                int dequeued = queue.dequeue();
                result.add(dequeued);
            }
        }
        for (int val : result) {
            System.out.println(val);
        }
        scanner.close();
    }
}

