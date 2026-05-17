class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int res = 0;
        int j = 0;
        while(j< prices.length)
        {
            if(prices[j] < buy)
            {
                buy = prices[j];
            }else
            {
                res = Math.max(res, prices[j] - buy);
            }
            j++;
        }
        return res;
    }
}
