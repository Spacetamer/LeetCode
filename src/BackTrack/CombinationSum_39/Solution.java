package BackTrack.CombinationSum_39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new LinkedList<>(), res);
        return res;
    }

    private void backTrack(int[] candidates, int rest, int index, LinkedList<Integer> current, List<List<Integer>> res){
        if (rest == 0){
            res.add(new LinkedList<>(current));
            return;
        }

        for (int i=index; i<candidates.length; ++i){
            int v = candidates[i];
            if (v > rest) break;
            current.add(v);
            backTrack(candidates, rest-v, i, current, res);
            current.removeLast();
        }
    }
}
