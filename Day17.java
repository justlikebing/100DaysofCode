import java.util.Stack;
public class Day17 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (!stack.isEmpty() && isMatchingPair(stack.peek(), ch)) {
                stack.pop();
            } else {
                return false; 
            }
        }

        return stack.isEmpty(); 
    }

    private boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') || (open == '{' && close == '}') || (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        Day17 validator = new Day17();

        // Example usage
        String testString1 = "()[]{}";
        String testString2 = "([)]";
        String testString3 = "{[]}";

        System.out.println("Is '" + testString1 + "' valid? " + validator.isValid(testString1));
        System.out.println("Is '" + testString2 + "' valid? " + validator.isValid(testString2));
        System.out.println("Is '" + testString3 + "' valid? " + validator.isValid(testString3));
    }
}
