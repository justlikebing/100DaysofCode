import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {
    private final Map<Integer, Integer> vals; // Key-Value pairs
    private final Map<Integer, Integer> counts; // Key-Use counts
    private final Map<Integer, LinkedHashSet<Integer>> lists; // Use count-Keys mapping
    private int minCount; // Minimum use count
    private final int capacity; // Cache capacity

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minCount = 0;
        this.vals = new HashMap<>();
        this.counts = new HashMap<>();
        this.lists = new HashMap<>();
    }

    public int get(int key) {
        if (!vals.containsKey(key)) {
            return -1;
        }
        int count = counts.get(key);
        counts.put(key, count + 1);
        lists.get(count).remove(key);
        if (count == minCount && lists.get(count).size() == 0) {
            minCount++;
        }
        if (!lists.containsKey(count + 1)) {
            lists.put(count + 1, new LinkedHashSet<>());
        }
        lists.get(count + 1).add(key);
        return vals.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (vals.containsKey(key)) {
            vals.put(key, value);
            get(key); // Increment count
            return;
        }
        if (vals.size() >= capacity) {
            int evict = lists.get(minCount).iterator().next();
            lists.get(minCount).remove(evict);
            vals.remove(evict);
            counts.remove(evict);
        }
        vals.put(key, value);
        counts.put(key, 1);
        minCount = 1;
        if (!lists.containsKey(1)) {
            lists.put(1, new LinkedHashSet<>());
        }
        lists.get(1).add(key);
    }
}

public class Day80 {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        
        lfuCache.put(1, 1);
        lfuCache.put(2, 2);
        System.out.print(lfuCache.get(1) + " "); // Output: 1
        lfuCache.put(3, 3);
        System.out.print(lfuCache.get(2) + " "); // Output: -1
        System.out.println(lfuCache.get(3)); // Output: 3
    }
}
