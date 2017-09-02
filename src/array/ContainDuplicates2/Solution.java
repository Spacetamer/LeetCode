package array.ContainDuplicates2;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int N = nums.length;
        if (k > N) return false;
        int i = 0;
        for (int num: nums){
            for (int j = Math.min(i+k, N-1); j>i; --j)
                if (nums[j] == num) return true;
            ++i;
        }
        return false;
    }
}
