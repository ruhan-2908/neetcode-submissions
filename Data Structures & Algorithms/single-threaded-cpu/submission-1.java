class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Integer[] indices = new Integer[n];
        for(int i=0;i<n;i++)
        {
            indices[i] = i;
        }

        Arrays.sort(indices, (a,b) -> tasks[a][0] != tasks[b][0] ? tasks[a][0] - tasks[b][0] : a-b);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] : a-b);

        long time = 0;
        int i = 0;
        int[] res = new int[n];
        int k = 0;
        while(!pq.isEmpty() || i < n)
        {
            while(i< n && tasks[indices[i]][0] <= time)
            {
                pq.offer(indices[i]);
                i++;
            }

            if(pq.isEmpty())
            {
                time = tasks[indices[i]][0];
            }else
            {
                int nextIdx = pq.poll();
                time += tasks[nextIdx][1];
                res[k++] = nextIdx;
            }
        }
        return res;
    }
}