class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] ans = new int[nums.length - k + 1];
        int idx = 0;
        for(int j = 0 ; j < nums.length ; j++)
        {
            pq.offer(new int[]{nums[j],j});
            if(j >= k-1)
            {
                while(pq.peek()[1] < j - k + 1)
                {
                    pq.poll();
                }
                ans[idx++] = pq.peek()[0];
            }
        }
        return ans;
    }
}
