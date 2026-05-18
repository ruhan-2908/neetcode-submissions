class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            long time  = 0;
            for(int pile : piles)
            {
                time += Math.ceil((double) pile/mid);
            }
            if(time <= h)
            {
                res = mid;
                j = mid - 1;
            }else
            {
                i = mid + 1;
            }
        }
        return res;
    }
}
