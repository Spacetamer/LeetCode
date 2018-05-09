package Stack.NextGreaterElement_496;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Map<Integer, Integer> map = nextGreat(nums2);
        int i=0;
        for (int num: nums1)
            result[i++] = map.get(num);
        return result;
    }

    private HashMap<Integer, Integer> nextGreat(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> temp = new Stack<>();
        for (int num: nums){
            while (!temp.isEmpty() && num > temp.peek())
                map.put(temp.pop(), num);
            temp.push(num);
        }

        for (int num: temp)
            map.put(num, -1);

        return map;
    }
}
