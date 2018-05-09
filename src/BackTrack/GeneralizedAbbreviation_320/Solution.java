package BackTrack.GeneralizedAbbreviation_320;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private int len;
    public List<String> generateAbbreviations(String word) {
        len = word.length();
        List<String> res = new LinkedList<>();
        backTrack(res, new StringBuilder(), word.toCharArray(), 0, true);
        return res;
    }

    private void backTrack(List<String> res, StringBuilder sb, char[] word, int index, boolean flag){
        if (index == len) {
            res.add(sb.toString());
            return;
        }

        int maxNum = len - index;
        int length = sb.length();
        sb.append(word[index]);
        backTrack(res, sb, word, index+1, true);
        sb.setLength(length);

        if (flag)
            for (int i=1; i<=maxNum; ++i){
                sb.append(i);
                backTrack(res, sb, word, index+i, false);
                sb.setLength(length);
            }
    }
}
