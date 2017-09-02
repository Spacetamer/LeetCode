package array.ContainDuplicates;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num: nums){
            if (num > max) max = num;
            if (num < min) min = num;
        }

        boolean[] contain = new boolean[max-min+1];
        for (int num: nums){
            int index = num - min;
            if (contain[index]) return true;
            contain[index] = true;
        }
        return false;
    }
}
