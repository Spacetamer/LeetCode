package string.ReverseString_541;

class Solution {
    public String reverseStr(String s, int k) {
        char[] content = s.toCharArray();

        int left = -k, right = -1;
        while (right < content.length){
            left = right + k;
            right = left + k;
        }

        return new String(content);
    }
}
