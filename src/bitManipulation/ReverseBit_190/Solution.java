package bitManipulation.ReverseBit_190;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int x=32;
        while (x != 0){
            result <<= 1;
            result += n&1;
            n >>>= 1;
            --x;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(3));
    }
}
