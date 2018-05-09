package string.LengthOfLastWord_58;

class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        boolean flag=true;
        for (char c: s.toCharArray()){
            if (c != ' '){
                if (flag) {
                    count = 1;
                    flag = false;
                }
                else ++count;
            }
            else flag = true;
        }
        return count;
    }
}
