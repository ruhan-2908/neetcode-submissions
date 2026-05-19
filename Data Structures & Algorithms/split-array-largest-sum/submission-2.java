class Solution {
    public int splitArray(int[] nums, int k) {
        int l = 0;
        int r = 0;
        for(int i : nums)
        {
            if(l < i) l = i;
            r += i;
        }
        int res = 0;
        while(l<=r)
        {
            int m = l + (r-l)/2;
            if(checksplit(nums,k,m))
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
    public boolean checksplit(int[] nums, int k , int m)
    {
        int count = 0;
        int sum = 0;
        for(int i : nums)
        {
            if(sum + i > m)
            {
                count++;
                sum = i;
            }else sum += i;
        }
        count++;
        return count <= k; 
    }
}