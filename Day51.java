import java.util.*;

public class Day51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); 
        
        while (t-- > 0) {
            int n = scanner.nextInt(); // number of days
            int m = scanner.nextInt(); // number of chapters
            int[] time = new int[m]; // array to store time required for each chapter
            
            for (int i = 0; i < m; i++) {
                time[i] = scanner.nextInt();
            }
            
            int low = 0;
            int high = (int) Math.pow(10, 9); // maximum possible time
            
            while (low < high) {
                int mid = low + (high - low) / 2;
                
                if (isPossible(time, n, mid)) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            
            System.out.println(low); // print the result
        }
    }
    
    private static boolean isPossible(int[] time, int n, int maxTime) {
        int days = 1;
        int currentWorkload = 0;
        
        for (int t : time) {
            if (t > maxTime) {
                return false; 
            }
            
            if (currentWorkload + t > maxTime) {
                days++;
                currentWorkload = 0;
            }
            
            currentWorkload += t;
        }
        
        return days <= n; 
    }
}
