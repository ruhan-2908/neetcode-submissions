class Solution {
    public int splitArray(int[] nums, int k) {
        int i = Integer.MIN_VALUE;
        int j = 0;
        for(int num : nums)
        {
            if(i < num)
            {
                i = num;
            }
            j = j + num;
        }
        int res =0;
        while(i<=j)
        {
            int mid = i + (j-i)/2;
            if(checksplit(nums,k,mid))
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
    public boolean checksplit(int[] nums, int k , int mid)
    {
        int count= 0;
        int sum =0;
        for(int i : nums)
        {
            sum += i;
            if(sum > mid)
            {
                count++;
                sum = i;
            }
        }
        count++;
        return count <= k;
    }
}