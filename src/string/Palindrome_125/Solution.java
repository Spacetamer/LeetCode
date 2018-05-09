package string.Palindrome_125;

class Solution {
    public boolean isPalindrome(String s) {
        char[] string = s.toLowerCase().toCharArray();
        int left = 0, right = string.length - 1;
        while (left < right){
            while (!isAlphaNumeric(string[left]) && left<right) ++left;
            while (!isAlphaNumeric(string[right]) && left<right) --right;
            if (string[left] != string[right] && left < right) return false;
            ++left;
            --right;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c){
        if ('0'<=c && c<='9') return true;
        if ('a'<=c && c<='z') return true;
        return false;
    }
}
