package Math.UglyNumber2_264;

class Solution {
    public int nthUglyNumber(int n) {
        if (n<=3) return n;
        int count = 3, current = 3;
        while(count!=n){
            ++current;
            if(isUgly(current)) ++count;
        }

        return current;
    }

    private boolean isUgly(int x){
        while(x % 2 == 0) x/=2;
        while(x % 3 == 0) x/=3;
        while(x % 5 == 0) x/=5;

        return x==1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1352));
    }
}