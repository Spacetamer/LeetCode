package array.MaxConsecutiveOnes;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int N = nums.length;
        int[] count = new int[(N-1)/2 + 1];

        int wave = 0;
        boolean interrupted = false;
        for (int num: nums){
            if (num == 1){
                ++count[wave];
                interrupted = false;
            }
            else if (!interrupted){
                interrupted = true;
                ++wave;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int counting: count)
            if (counting > max)
                max = counting;
        return max;
    }
}
