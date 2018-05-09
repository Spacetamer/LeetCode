package BackTrack.WordSearch_212;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        TrieNode root = buildTrie(words);
        for (int i=0; i<board.length; ++i)
            for (int j=0; j<board[0].length; ++j)
                dfs(root, board, i, j, res);
        return res;
    }

    private void dfs(TrieNode root, char[][] board, int row, int col, List<String> res){
        char c = board[row][col];
        if (c == '#' || root.next[c-'a'] == null) return;

        root = root.next[c-'a'];
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }

        board[row][col] = '#';
        if (row > 0) dfs(root, board, row-1, col, res);
        if (row < board.length-1) dfs(root, board, row+1, col, res);
        if (col > 0) dfs(root, board, row, col-1, res);
        if (col < board[0].length-1) dfs(root, board, row, col+1, res);
        board[row][col] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for (String word: words){
            TrieNode p = root;
            for (char c: word.toCharArray()){
                int index = c - 'a';
                if (p.next[index] == null) p.next[index] = new TrieNode();
                p = p.next[index];
            }
            p.word = word;
        }
        return root;
    }

    private class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
