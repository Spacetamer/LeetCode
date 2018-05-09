package DynamicProgramming.BuyAndSellStock3_123;

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) return 0;
        int first = 0, second = Integer.MIN_VALUE, prev = prices[0];
        for (int i=1; i<prices.length; ++i){
            int curr = prices[i];
            int profit = curr - prev;
            if (profit > first) first = profit;
            else if (profit > second) second = profit;
            prev = curr;
        }

        return second > 0 ? first+second : first;
    }
}
