package string.ReverseString_344;

class Solution {
    public String reverseString(String s) {
        char[] content = s.toCharArray();
        int left = 0, right = content.length - 1;
        while (left < right){
            char temp = content[left];
            content[left] = content[right];
            content[right] = temp;
            ++left;
            --right;
        }

        return new String(content);
    }
}
