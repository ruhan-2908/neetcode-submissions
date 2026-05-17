class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int profit = 0;
        int maxProfit = 0;
        for(int price : prices)
        {
            if(price < buy) buy = price;
            else
            {
                profit = price - buy;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
