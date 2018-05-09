package array.TwoSum;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] position = new int[target+1];
        for (int i=0; i!=target; ++i) position[i] = -1;
        for (int i = 0; i != nums.length; ++i){
            int num = nums[i];
            if (target < num) continue;
            int another = position[target-num];
            if (another != -1)
                return new int[]{another, i};
            position[num] = i;
        }

        return null;
    }
}
