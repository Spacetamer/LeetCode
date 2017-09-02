package array.MaximumSubarray;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int N = nums.length;
        if (N==1) return nums[0];
        int sum = 0;
        for (int i=0; i!=k; ++i) sum += nums[i];
        int maxSum = sum;

        for (int i=k; i<N; ++i){
            sum += (nums[i] - nums[i-k]);
            maxSum = Math.max(maxSum, sum);
        }

        return ((double) maxSum) / k;
    }
}
