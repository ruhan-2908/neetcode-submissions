class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Integer[] indices = new Integer[n];
        for(int i = 0; i < n ; i++)
        {
            indices[i] = i;
        }   
        Arrays.sort(indices, (a,b) -> tasks[a][0] != tasks[b][0] ? tasks[a][0] - tasks[b][0] : a - b);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> tasks[a][1] != tasks[b][1] ? tasks[a][1] - tasks[b][1] : a - b);

        int[] res = new int[n];
        int i = 0;
        int k = 0;
        long time = 0;
        while(!pq.isEmpty() || i < n)
        {
            while(i < n &&  tasks[indices[i]][0] <= time)
            {
                pq.offer(indices[i]);
                i++;
            }
            if(pq.isEmpty())
            {
                time = tasks[indices[i]][0];
            }else
            {
                int workTime = pq.poll();
                time  += tasks[workTime][1];
                res[k++] = workTime;
            }
        }
        return res;
    }
}