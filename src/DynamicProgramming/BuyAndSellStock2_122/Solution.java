package DynamicProgramming.BuyAndSellStock2_122;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int prev = prices[0];
        int profit = 0;

        for (int curr: prices){
            if (curr > prev) profit += curr - prev;
            prev = curr;
        }

        return profit;
    }
}
