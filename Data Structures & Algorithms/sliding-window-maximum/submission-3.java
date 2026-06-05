class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        int end = 0;
        int idx = 0;
        while(end < nums.length)
        {
            pq.offer(new int[]{end,nums[end]});
            if(end >= k -1)
            {
                while(pq.peek()[0] <= end - k) pq.poll();
                ans[idx++] = pq.peek()[1];
            }   
            end++;
        }
        return ans;
    }
}
