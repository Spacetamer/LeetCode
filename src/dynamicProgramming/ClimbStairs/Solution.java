package dynamicProgramming.ClimbStairs;

public class Solution {
    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int prev_one = 1;
        int prev_two = 1;
        int sum = 2;
        for (int i=3; i<=n; ++i){
            prev_two = prev_one;
            prev_one = sum;
            sum = prev_one + prev_two;
        }
        return sum;
    }
}
