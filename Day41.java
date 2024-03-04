import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day41 {

    public ArrayList<Integer> countDistinct(ArrayList<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        
        if (B > A.size()) {
            return result;
        }

        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < B; i++) {
            frequencyMap.put(A.get(i), frequencyMap.getOrDefault(A.get(i), 0) + 1);
        }

        result.add(frequencyMap.size());

        for (int i = B; i < A.size(); i++) {
            int leftElement = A.get(i - B);
            frequencyMap.put(leftElement, frequencyMap.get(leftElement) - 1);
            if (frequencyMap.get(leftElement) == 0) {
                frequencyMap.remove(leftElement);
            }

            int currentElement = A.get(i);
            frequencyMap.put(currentElement, frequencyMap.getOrDefault(currentElement, 0) + 1);

            result.add(frequencyMap.size());
        }

        return result;
    }

    public static void main(String[] args) {
        Day41 solution = new Day41();

        ArrayList<Integer> A1 = new ArrayList<>(List.of(1, 2, 1, 3, 4, 3));
        int B1 = 3;
        System.out.println("Example 1:");
        System.out.println(solution.countDistinct(A1, B1));

        ArrayList<Integer> A2 = new ArrayList<>(List.of(1, 1, 2, 2));
        int B2 = 1;
        System.out.println("Example 2:");
        System.out.println(solution.countDistinct(A2, B2));
    }
}
