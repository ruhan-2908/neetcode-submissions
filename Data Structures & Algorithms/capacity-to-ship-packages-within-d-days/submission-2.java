class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int res = 0;
        for(int i : weights)
        {
            if(min > i) min = i;
            max += i;
        }
        while(min <= max)
        {
            int mid = min +(max-min)/2;
            if(checkcap(mid, weights, days))
            {
                res = mid;
                max = mid - 1;
            }else
            {
                min = mid + 1;
            }
        }
        return res;
    }
    public boolean checkcap(int cap , int[] weights, int days)
    {
        int totDays = 0;
        int totWeight =0;

        for(int i = 0 ; i < weights.length ; )
        {
            if(weights[i] > cap) return false;
            if(totWeight + weights[i] <= cap) totWeight += weights[i++];
            else
            {
                totWeight = 0;
                totDays++;
            }
        }
        totDays++;
        return totDays <= days;
    }
}