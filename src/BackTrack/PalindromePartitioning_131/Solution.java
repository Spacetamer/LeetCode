package BackTrack.PalindromePartitioning_131;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private int length;

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        LinkedList<String> solution = new LinkedList<>();
        this.length = s.length();
        backTrack(ans, solution, s.toCharArray(), 0);
        return ans;
    }

    private void backTrack(List<List<String>> ans, LinkedList<String> solution, char[] str, int pos){
        if (pos==length) {
            ans.add(new LinkedList<>(solution));
            return;
        }
        solution.add(String.valueOf(str[pos]));
        backTrack(ans, solution, str, pos+1);
        solution.removeLast();

        for (int len=2; len<=length-pos; ++len) {
            if (isPalindrome(str, pos, len)) {
                solution.add(String.copyValueOf(str, pos, len));
                backTrack(ans, solution, str, pos+len);
                solution.removeLast();
            }
        }
    }

    private boolean isPalindrome (char[] str, int left, int len) {
        int right = left + len - 1;
        while (left < right)
            if (str[left++] != str[right--])
                return false;
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> ans = new Solution().partition("aab");
        for (List<String> solution: ans){
            for (String word: solution)
                System.out.println(word);
            System.out.println("------");
        }
    }
}
