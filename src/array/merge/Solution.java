package array.merge;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n -1;
        int i = m - 1, j = n - 1;

        for (; i>=0 && j>=0 && k!=0; --k){
            int a1 = nums1[i];
            int a2 = nums2[j];

            if (a1 > a2){
                nums1[k] = a1;
                --i;
            } else {
                nums1[k] = a2;
                --j;
            }
        }

        if (j < 0) return;
        if (i < 0) {
            for (i = 0; i <= j; ++i)
                nums1[i] = nums2[i];
        }
    }
}
