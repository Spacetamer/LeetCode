package Math.LargestPalindromeProduct_479;

class Solution {
    public int largestPalindrome(int n) {
        PalindromeGenerator palindromeGenerator = new PalindromeGenerator(n);
        long result;
        do {
            result = palindromeGenerator.next();
            if (palindromeGenerator.canBeFactor(result)) break;
        } while (true);

        return (int) result % 1337;
    }

    private class PalindromeGenerator{

        private int digit;
        private long order;

        public PalindromeGenerator(int n){
            order = power(n);
            digit = n;
        }

        public long next(){
            --order;
            String str = order + new StringBuilder().append(order).reverse().toString();
            System.out.println(str);
            return Long.parseLong(str);
        }

        private long power(int n){
            int x = 1;
            while (n > 0) x *= 10;
            return x;
        }

        private boolean canBeFactor(long n) {
            long divisor = power(digit - 1);
            long upperBound = power(digit);
            long result;

            do {
                result = n / ++divisor;
                if (n % divisor == 0 && result < upperBound) return true;
            } while (result > divisor);

            return false;
        }
    }
}
