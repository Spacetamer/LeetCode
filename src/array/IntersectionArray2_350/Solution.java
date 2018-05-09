package array.IntersectionArray2_350;

import java.util.*;

class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[]{};
        Map<Integer, Integer> count = new HashMap<>();
        for (int i: nums1){
            Integer value = count.get(i);
            if (value == null) count.put(i, 1);
            else count.put(i, ++value);
        }

        List<Integer> results = new ArrayList<>();
        for (int i: nums2){
            Integer value = count.get(i);
            if (value != null && value != 0) {
                results.add(i);
                count.put(i, --value);
            }
        }

        int[] result = new int[results.size()];
        for (int i=0; i != results.size(); ++i) {
            result[i] = results.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3};
        int[] nums2 = new int[]{1,3};
        for (int i: intersect(nums1, nums2))
            System.out.println(i);
    }
}
