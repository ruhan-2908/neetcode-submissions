class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
        for(int stone : stones)
        {
            pq.offer(stone);
        }
        while(pq.size() > 1)
        {
            int diff = Math.abs(pq.poll() - pq.poll());
            if(diff != 0) pq.offer(diff);
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
