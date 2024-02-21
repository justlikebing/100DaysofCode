import java.util.ArrayList;
import java.util.List;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word;
}

public class Day16 {

    private void insertWord(TrieNode root, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.word = word;
    }

    private void search(char[][] board, int i, int j, TrieNode node, List<String> result) {
        char ch = board[i][j];
        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];
        if (node.word != null) {
            result.add(node.word);
            node.word = null; 
        }

        board[i][j] = '#'; 

        if (i > 0) search(board, i - 1, j, node, result);
        if (i < board.length - 1) search(board, i + 1, j, node, result);
        if (j > 0) search(board, i, j - 1, node, result);
        if (j < board[0].length - 1) search(board, i, j + 1, node, result);

        board[i][j] = ch; 
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, i, j, root, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Day16 wordSearchII = new Day16();
        char[][] board = {
            {'o', 'a', 'a', 'n'},
            {'e', 't', 'a', 'e'},
            {'i', 'h', 'k', 'r'},
            {'i', 'f', 'l', 'v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> result = wordSearchII.findWords(board, words);
        System.out.println("Words found on the board: " + result);
    }
}
