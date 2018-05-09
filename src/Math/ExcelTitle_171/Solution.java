package Math.ExcelTitle_171;

class Solution {
    public int titleToNumber(String s) {
        char[] title = s.toCharArray();
        int len = title.length;
        int result = 0;

        for (int i=0; i!=len; ++i){
            int c = title[len - 1 - i] - 'A' + 1;
            for (int j=0; j<i; ++j) c *= 26;
            result += c;
        }

        return result;
    }
}
