package BackTrack.CombinationSum3_216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new LinkedList<>();
        if (n*2>=k*(k+1) && n*2<=(19-k)*k)
            backTrack(res, new LinkedList<>(), n, k, 0);
        return res;
    }

    private void backTrack(List<List<Integer>> res, LinkedList<Integer> sol, int n, int k, int last){
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(sol));
            return;
        }

        if (k != 0 && n > last) {
            for (int i=last+1; i<10; ++i){
                sol.add(i);
                backTrack(res, sol, n-i, k-1, i);
                sol.removeLast();
            }
        }
    }
}
