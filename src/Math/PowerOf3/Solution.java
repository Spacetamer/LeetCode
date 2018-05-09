package Math.PowerOf3;

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) return false;
        for (long i=1; ;i *= 3) {
            if (i > n) return false;
            if (i == n) return true;
        }
    }
}
