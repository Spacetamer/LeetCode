package string.DetectCapital;

public class Solution {
    public boolean detectCapitalUse(String word) {
        char[] charArray = word.toCharArray();
        int N = charArray.length;
        int capital = 0;
        for (char c: charArray)
            if ('Z' >= c) ++capital;
        return  (capital == N || capital == 0 || (capital == 1 && charArray[0]<='Z'));
    }
}
