package BackTrack.AddAndSearchWord_211;

class WordDictionary {
    private Node root;

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node target = root;
        for (char c: word.toCharArray()){
            if (target.next[c-'a'] == null) target.next[c-'a'] = new Node();
            target = target.next[c-'a'];
        }
        target.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] str, int i, Node root){
        if (i == str.length) return root.isWord;
        char c = str[i];
        if (c != '.') return root.next[c-'a'] != null && match(str, i+1, root.next[c-'a']);
        for (Node next: root.next) {
            if (next!=null && match(str, i+1, next))
                return true;
        }
        return false;
    }

    private class Node{
        Node[] next;
        boolean isWord = false;
        private Node(){
            next = new Node[26];
        }
    }
}
