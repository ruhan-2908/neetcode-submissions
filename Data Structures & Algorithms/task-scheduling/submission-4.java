class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] check = new int[26];
        for(char t : tasks) check[t - 'A']++;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        int time = 0;
        for(int c : check) 
        {
            if(c>0) pq.offer(c);
        }
        Queue<int[]> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty())
        {
            time++;
            if(pq.isEmpty())
            {
                time = q.peek()[1];
            }
            else
            {
                int task = pq.poll();
                task--;
                if(task > 0) q.offer(new int[]{task,time+n});
            }
            if(!q.isEmpty() && q.peek()[1] == time) pq.offer(q.poll()[0]);
        }
        return time;
    }
}
