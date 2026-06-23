class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int n = queries.length;
        int[] ans = new int[n];
        Integer[] idx = new Integer[n];
        for(int i = 0 ; i < n  ; i++) idx[i] = i;
        Arrays.sort(idx,(a,b) -> queries[a] - queries[b]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        int inter = 0;
        for(int i = 0; i < n ; i++)
        {
            while(inter < intervals.length && intervals[inter][0] <= queries[idx[i]])
            {
                minHeap.offer(new int[]{intervals[inter][1],intervals[inter][1] - intervals[inter][0]+1});
                inter++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[0] < queries[idx[i]])
            {
                minHeap.poll();
            }
            
            ans[idx[i]] = minHeap.isEmpty() ? -1 : minHeap.peek()[1];
        }

        return ans;
    }
}
