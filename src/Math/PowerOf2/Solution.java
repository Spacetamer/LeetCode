package Math.PowerOf2;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        for (long i=1; ;i *= 2) {
            if (i > n) return false;
            if (i == n) return true;
        }
    }
}
