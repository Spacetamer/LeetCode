package DynamicProgramming.BuyAndSellStockCoolDown_309;

class Solution {
    public int maxProfit(int[] prices) {
        int profitSell = 0, profitNotSell=0;
        for (int i=1; i<prices.length; ++i){
            int profit = prices[i] - prices[i-1];
            int temp = profitNotSell;
            profitNotSell = Math.max(profitNotSell, profitSell);
            profitSell = profit > 0 ? (temp + profit) : temp;
        }

        return Math.max(profitNotSell, profitSell);
    }
}
