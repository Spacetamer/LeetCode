package BackTrack.GenerateParentheses_22;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backTrack(res, "", 0, 0, n);
        return res;
    }

    private void backTrack(List<String> res, String current, int left, int right, int max){
        if (current.length() == 2*max){
            res.add(current);
            return;
        }

        if (left < max) backTrack(res, current+"(", left+1, right, max);
        if (right < left) backTrack(res, current+")", left, right+1, max);
    }
}