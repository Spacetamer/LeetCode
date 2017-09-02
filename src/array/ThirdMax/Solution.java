package array.ThirdMax;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int res = nums[nums.length-1];
        int flag = 1;
        for (int i = nums.length-2; i>=0; --i){
            int current = nums[i];
            if (current < res){
                res = current;
                ++flag;
            }

            if (flag==3)
                return res;
        }

        return nums[nums.length-1];
    }

    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num: nums) {
            pq.add(num);
        }

        if (pq.size() < 3)
            return pq.poll();
        return 0;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(1);
        pq.add(3);
        pq.add(3);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
