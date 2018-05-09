package Math.FactorialTrailingZeroes_172;

class Solution {
    public int trailingZeroes(int n) {
        int i = 0;
        long product = 5;
        while (n >= product) {
            i += n/product;
            product *= 5;
        }

        return i;
    }
}
