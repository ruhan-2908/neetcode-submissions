class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char ch : tasks)
        {
            count[ch - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int c : count)
        {
            if(c > 0 ) pq.offer(c);
        }
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while(!q.isEmpty() || !pq.isEmpty())
        {
            time++;
            if(!pq.isEmpty())
            {
                int cnt = pq.poll();
                cnt--;
                if(cnt != 0) q.offer(new int[]{cnt,time+n});
            }else
            {
                time = q.peek()[1];
            }
            if(!q.isEmpty() && q.peek()[1] == time)
            {
                pq.offer(q.poll()[0]);
            }
        }
        return time;
    }
}
