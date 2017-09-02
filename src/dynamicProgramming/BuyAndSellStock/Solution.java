package dynamicProgramming.BuyAndSellStock;

public class Solution {
    public static int maxProfit(int[] prices) {
        int N = prices.length;
        if (N <= 0) return 0;
        int minSoFar = prices[0];
        int maxSoFar = 0;
        for (int i=1; i<N; ++i){
            int current = prices[i];
            int profit = current - minSoFar;
            if (profit > maxSoFar){
                maxSoFar = profit;
            }
            if (current < minSoFar)
                minSoFar = current;
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }
}
