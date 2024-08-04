import java.util.LinkedList;
// Custom implementation of a basic hash table with chaining for collision resolution
public class Day23<K, V> {
    private static final int TABLE_SIZE = 10;

    private LinkedList<Entry<K, V>>[] table;
    // Entry class to represent key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Constructor to initialize the hash table
    public Day23() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    // Hash function to determine the index in the array
    private int hashFunction(K key) {
        return key.hashCode() % TABLE_SIZE;
    }

    // Method to put a key-value pair into the hash table
    public void put(K key, V value) {
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Check if the key already exists, and update the value if so
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        // If the key doesn't exist, add a new entry
        bucket.add(new Entry<>(key, value));
    }

    // Method to get the value associated with a key from the hash table
    public V get(K key) {
        int index = hashFunction(key);
        LinkedList<Entry<K, V>> bucket = table[index];

        // Search for the key in the bucket
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        // Key not found
        return null;
    }

    public static void main(String[] args) {
        // Example usage:
        Day23<String, Integer> hashTable = new Day23<>();
        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);

        System.out.println("Value for key 'two': " + hashTable.get("two"));
        System.out.println("Value for key 'four': " + hashTable.get("four"));
    }
}
