package BackTrack.PermutaionsWithDuplicates_47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(nums, nums.length, new LinkedList<>(), res);
        return res;
    }

    private void backTrack(int[] nums, int count, LinkedList<Integer> current, List<List<Integer>> res){
        if (count == 0) {
            res.add(new LinkedList<>(current));
            return;
        }

        int prev = Integer.MAX_VALUE;
        for (int i=0; i!=nums.length; ++i){
            int num = nums[i];
            if (num == prev || num == Integer.MAX_VALUE) continue;
            current.add(num);
            prev = num;
            nums[i] = Integer.MAX_VALUE;
            backTrack(nums, count-1, current, res);
            current.removeLast();
            nums[i] = num;
        }
    }
}
