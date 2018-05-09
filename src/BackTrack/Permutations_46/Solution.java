package BackTrack.Permutations_46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        backTrack(res, 0, new int[nums.length], nums, new boolean[nums.length]);
        return res;
    }

    private void backTrack(List<List<Integer>> res, int index, int[] permutation, int[] nums, boolean[] visited){
        if (index == nums.length){
            List<Integer> ans = new LinkedList<>();
            for (int num: permutation) ans.add(num);
            res.add(ans);
            return;
        }

        int prev = Integer.MAX_VALUE;
        for (int i=0; i!= nums.length; ++i){
            if (visited[i]) continue;
            int curr = nums[i];
            if (prev == curr) continue;
            visited[i] = true;
            permutation[index] = curr;
            backTrack(res, index+1, permutation, nums,visited);
            visited[i] = false;
            prev = curr;
        }
    }
}
