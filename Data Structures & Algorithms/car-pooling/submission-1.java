class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int[] trip : trips) pq.offer(trip);
        while(!pq.isEmpty())
        {
            int[] currentTrip = pq.poll();
            int weight = currentTrip[0];
            while(!pq.isEmpty() && pq.peek()[1] < currentTrip[2])
            {
                weight += pq.poll()[0];
                if(weight > capacity) return false;
            }
        }
        return true;
    }
}