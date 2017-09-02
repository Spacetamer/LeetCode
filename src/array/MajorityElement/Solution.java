package array.MajorityElement;

import java.util.HashMap;

public class Solution {
    public static int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;

        for (int num : nums) {
            if (res == num) ++count;
            else --count;

            if (count == 0) {
                res = num;
                count = 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] indice = new int[]{1,3,3,4,-1,3,3};

        System.out.println(majorityElement(indice));
    }
}
