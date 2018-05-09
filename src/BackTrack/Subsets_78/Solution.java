package BackTrack.Subsets_78;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        boolean[] selected = new boolean[nums.length];
        List<List<Integer>> res = new LinkedList<>();
        backTrack(res, 0, selected, nums);
        return res;
    }

    private void backTrack(List<List<Integer>> res, int index, boolean[] selected, int[] nums){
        if (index == nums.length) {
            List<Integer> subset = new LinkedList<>();
            for (int i=0; i!= nums.length; ++i)
                if (selected[i]) subset.add(nums[i]);
            res.add(subset);
            return;
        }

        backTrack(res, index+1, selected, nums);
        selected[index] = true;
        backTrack(res, index+1, selected, nums);
        selected[index] = false;
    }
}
