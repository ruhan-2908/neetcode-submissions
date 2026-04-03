class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int[] trip : trips)
        {
            pq.offer(trip);
        }   
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            int cap = temp[0];
            while(!pq.isEmpty() && pq.peek()[1] < temp[2])
            {
                cap += pq.poll()[0];
            }
            if(cap > capacity)
            {
                return false;
            }
        }
        return true;
    }
}