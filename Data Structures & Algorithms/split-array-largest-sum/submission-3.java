class Solution {
    public int splitArray(int[] nums, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int i : nums)
        {
            if(l < i) l = i;
            r+=i;
        }
        int res = 0;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(check(m,k,nums))
            {
                res = m;
                r = m - 1;
            }else
            {
                l = m + 1;
            }
        }
        return res;
    }
    public boolean check(int checkSplit, int realK , int[] nums)
    {
        int count = 1;
        int sum = 0;
        for(int num : nums)
        {
            if(sum + num > checkSplit)
            {
                count++;
                sum = 0;
            }
            sum += num;
        }
        return count <= realK;
    }
}