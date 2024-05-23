import java.util.*;
public class Day100 {
        public static List<Integer> uniquePrimeFactors(int N) {
        List<Integer> factors = new ArrayList<>();
                while (N % 2 == 0) {
            if (!factors.contains(2))
                factors.add(2);
            N /= 2;
        }    
        for (int i = 3; i <= Math.sqrt(N); i += 2) {
            while (N % i == 0) {
                if (!factors.contains(i))
                    factors.add(i);
                N /= i;
            }
        }
        
        if (N > 2) {
            factors.add(N);
        }
        
        return factors;
    }
    
    public static void main(String[] args) {
        int N = 10;
        List<Integer> primeFactors = uniquePrimeFactors(N);
        System.out.println("Unique prime factors of " + N + " are: " + primeFactors);
    }
}
