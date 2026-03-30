class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for(char ch : tasks)
        {
            count[ch - 'A']++;
        }
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int num : count)
        {
            if(num > 0) maxheap.offer(num);
        }
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!maxheap.isEmpty() || !queue.isEmpty())
        {
            time++;
            if(maxheap.isEmpty())
            {
                time = queue.peek()[1];
            }
            else
            {
                int cnt = maxheap.poll() - 1;
                if(cnt>0)
                {
                    queue.offer(new int[]{cnt,time+n});
                }
            }
            if(!queue.isEmpty() && queue.peek()[1] == time)
            {
                maxheap.offer(queue.poll()[0]);
            }
        }
        return time;
    }
}
