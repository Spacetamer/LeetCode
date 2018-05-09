package array.NextPermutation_31;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        int k = nums.length - 1;
        for (int i = k-1; i >= 0; --i)
            if (nums[i]<nums[i+1]){
                k = i;
                break;
            }

        for (int l=nums.length-1; l>k; --l){
            if (nums[l] > nums[k]){
                int temp = nums[l];
                nums[l] = nums[k];
                nums[k] = temp;
                break;
            }
        }

        reverse(nums, k+1, nums.length-1);
    }

    private void reverse(int[] nums, int left, int right){
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            --right;
            ++left;
        }
    }
}
