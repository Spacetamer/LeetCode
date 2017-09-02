package array.MoveZeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int N = nums.length;
        int zeroStart = N;
        while (zeroStart != 0 && nums[--zeroStart] == 0);

        for (int i = zeroStart-1; i >= 0; --i){
            while (i != 0 && nums[i--] != 0);

        }
    }
}
