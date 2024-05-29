public class Day24 {
    private TrieNode root;
    public Day24() {
        root = new TrieNode('\0'); 
    }
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode(c);
            }
            node = node.children[index];
        }
        node.isEnd = true; 
    }
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEnd;
    }
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
       private TrieNode searchNode(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null; 
            }
            node = node.children[index];
        }
        return node;
    }
    public static void main(String[] args) {
        Day24 trie = new Day24();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");

        System.out.println("Search for 'app': " + trie.search("app")); 
        System.out.println("Search for 'orange': " + trie.search("orange")); 
        System.out.println("Starts with 'ap': " + trie.startsWith("ap")); // Output: true
    }
}
class TrieNode {
    char value;
    boolean isEnd;
    TrieNode[] children;

    TrieNode(char value) {
        this.value = value;
        this.isEnd = false;
        this.children = new TrieNode[26]; 
    }
}
