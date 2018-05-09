package BackTrack.CombinationSum2_40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<Integer> sol = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(candidates, 0, target, res, sol);
        return res;
    }

    private void backTrack(int[] candidates, int cursor, int target, List<List<Integer>> res, LinkedList<Integer> sol){
        if (target == 0) {
            res.add(new LinkedList<>(sol));
            return;
        }

        int last = -1;
        for (int i=cursor; i<candidates.length; ++i) {
            if (target>=candidates[i] && candidates[i]!=last){
                last = candidates[i];
                sol.add(last);
                backTrack(candidates, i+1, target-last, res, sol);
                sol.removeLast();
            }
        }
    }
}
