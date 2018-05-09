package DynamicProgramming.HouseRobber;

public class Solution {
    public int rob(int[] nums) {
        boolean lastRobbed = false;
        int maxSoFar = 0;
        int last = 0;
        int N = nums.length;

        for (int i = 0; i < N; ++i){
            int current = nums[i];
            if (!lastRobbed && current > 0){
                maxSoFar += current;
                lastRobbed = true;
            } else {
                if (current > last){
                    maxSoFar += (current - last);
                } else
                    lastRobbed = false;
            } 
            last = current;
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4};
        System.out.println();
    }
}
