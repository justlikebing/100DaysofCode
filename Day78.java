import java.util.Stack;
public class Day78 {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertAtRightPlace(stack, temp);
        }
    }
    private static void insertAtRightPlace(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int temp = stack.pop();
        insertAtRightPlace(stack, element);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(-2);
        stack.push(9);
        stack.push(-7);
        stack.push(3);

        sortStack(stack);

        System.out.print("Sorted Stack: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
