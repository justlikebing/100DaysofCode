import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    private final Map<Integer, Integer> cache;
    private final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}

public class Day79 {
    public static void main(String[] args) {
        int capacity = 3;
        LRUCache lruCache = new LRUCache(capacity);
        
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        lruCache.put(4, 5);
        
        System.out.println(lruCache.get(3)); // Output: 3
        System.out.println(lruCache.get(1)); // Output: -1
        System.out.println(lruCache.get(4)); // Output: 5
        
        lruCache.put(2, 3);
        System.out.println(lruCache.get(1)); // Output: -1
        System.out.println(lruCache.get(3)); // Output: 3
        System.out.println(lruCache.get(2)); // Output: 3
    }
}
