class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] check = new int[26];
        for(char ch : tasks) check[ch - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
        for(int i : check) 
        {
            if(i>0) maxHeap.offer(i);
        }
        Queue<int[]> q = new LinkedList<>();
        int time = 0; 
        while(!maxHeap.isEmpty() || !q.isEmpty())
        {
            time++;
            if(maxHeap.isEmpty())
            {
                time = q.peek()[1];
            }else
            {
                int currTask = maxHeap.poll();
                currTask--;
                if(currTask > 0) q.offer(new int[]{currTask,time+n});
            }
            if(!q.isEmpty() && q.peek()[1] == time) maxHeap.offer(q.poll()[0]);
        }
        return time;
    }
}
