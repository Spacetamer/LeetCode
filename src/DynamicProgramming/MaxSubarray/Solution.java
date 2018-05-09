package DynamicProgramming.MaxSubarray;

public class Solution {
    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=maxSoFar;
        int N = A.length;
        for (int i=1;i<N;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,-2,10,-20,5,4,4};
        System.out.println(maxSubArray(nums));
    }
}
