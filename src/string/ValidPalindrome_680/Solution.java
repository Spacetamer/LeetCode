package string.ValidPalindrome_680;

class Solution {
    public boolean validPalindrome(String s) {
        char[] string = s.toCharArray();
        int errorLeft = 1;
        int left = 0, right = string.length - 1;
        while (left < right){
            if (string[left] != string[right]){
                if (errorLeft > 0) {
                    --errorLeft;
                    ++left;
                } else return false;
            }
            ++left;
            --right;
        }
        return true;
    }
}
