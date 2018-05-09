package Math.HappyNumber_202;

class Solution {
    private int digitSquareSum(int n){
        int result = 0;
        while (n != 0){
            int temp = n % 10;
            result += temp * temp;
            n /= 10;
        }

        return result;
    }
    public boolean isHappy(int n) {
        while (n != 1 && n != 4){
            n = digitSquareSum(n);
        }

        return n==1;
    }
}
