class Solution {
    public int maxProfit(int[] prices) {
        int[] rightMax = new int[prices.length];
        Arrays.fill(rightMax,-1);
        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>-1;i--)
        {
            rightMax[i] = max;
            max = Math.max(max, prices[i]);
        }
        int maxProfit = 0;
        for(int i=0;i<prices.length;i++) maxProfit = Math.max(maxProfit,rightMax[i] - prices[i]);
        return maxProfit;
    }
}
