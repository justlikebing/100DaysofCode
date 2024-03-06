import java.util.Scanner;

class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEndOfWord = false;
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    public int countDistinctSubstrings() {
        return countDistinctSubstrings(root, 0);
    }

    private int countDistinctSubstrings(TrieNode node, int result) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                result = countDistinctSubstrings(node.children[i], result + 1);
            }
        }
        return result;
    }
}

public class Day44 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();
            Trie trie = new Trie();

            for (int i = 0; i < s.length(); i++) {
                trie.insert(s.substring(i));
            }

            int distinctSubstrings = trie.countDistinctSubstrings();
            System.out.println(distinctSubstrings);
        }

        scanner.close();
    }
}
