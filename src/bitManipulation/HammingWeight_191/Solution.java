package bitManipulation.HammingWeight_191;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int i=0;
        while (n != 0){
            i += n & 1;
            n >>>= 1;
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-3));
    }
}
