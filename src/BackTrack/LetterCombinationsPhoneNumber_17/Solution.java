package BackTrack.LetterCombinationsPhoneNumber_17;

import java.util.LinkedList;
import java.util.List;

class Solution {
    private static final String[] dict = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        combinationHelper(result, digits.toCharArray(), 0, "");
        return result;
    }

    private void combinationHelper(List<String> res, char[] content, int pos, String current){
        if (content.length == 0) return;
        if (pos == content.length) {
            res.add(current);
            return;
        }

        char c = content[pos];
        char[] digits = dict[c-'0'].toCharArray();

        for (char digit: digits) {
            combinationHelper(res, content, pos+1, current+digit);
        }
    }
}
