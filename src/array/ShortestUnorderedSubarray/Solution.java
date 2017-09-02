package array.ShortestUnorderedSubarray;

public class Solution {
    public static int findUnsortedSubarray(int[] nums) {
        int N = nums.length;
        int min, max;
        int left = 0, right = 0;
        int previous = nums[0];

        for (int i = 1; i<N; ++i){
            int current = nums[i];

            if (current < previous) {
                left = i-1;
                break;
            }
            previous = current;
        }

        previous = nums[N-1];
        for (int i = N-2; i>=0; --i){
            int current = nums[i];

            if (current > previous){
                right = i+1;
                break;
            }
            previous = current;
        }

        max = nums[left];
        min = nums[right];

        for (int i = left+1; i < right; ++i){
            int current = nums[i];
            if (current > max)
                max = current;
            else if (current < min)
                min = current;
        }

        for (int i = left-1; i >= 0 && nums[i]>min; --i, --left);
        for (int i = right+1; i < N && nums[i]<max; ++i, ++right);

        int sub_len = right-left + 1;
        return sub_len<=1? 0:sub_len;
    }

    public int findUnsortedSubarray2(int[] A) {
        int n = A.length, beg = -1, end = -2, min = A[n-1], max = A[0];
        for (int i=1;i<n;++i) {
            int left = A[i];
            int right = A[n-1-i];
            max = Math.max(max,left);
            min = Math.min(min, right);
            if (left < max) end = i;
            if (right > min) beg = n-1-i;
        }
        return end - beg + 1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,4,2,3,4,5};
        System.out.println(findUnsortedSubarray(array));
    }
}
