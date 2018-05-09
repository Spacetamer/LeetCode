package array.MoveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        for (int i=0, lastZero=0; i<N; ++i){
            int current = nums[i];
            if (current != 0){
                nums[i] = nums[lastZero];
                nums[lastZero++] = current;
            }
        }
    }
}
