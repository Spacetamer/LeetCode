package BackTrack.Combination_77;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new LinkedList<>();
        backTrack(res, new LinkedList<>(), 1, k, n);
        return res;
    }

    private void backTrack(List<List<Integer>> res, LinkedList<Integer> current, int index, int k, int n){
        if (k==0) {
            res.add(new LinkedList<>(current));
            return;
        }

        for (int i=index; i<=n; ++i){
            current.add(i);
            backTrack(res, current, i+1, k-1, n);
            current.removeLast();
        }
    }
}
