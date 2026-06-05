class Solution {
    HashMap<Integer,List<int[]>> adj;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new HashMap<>();
        for(int i = 1 ; i <= n ; i++) adj.put(i,new ArrayList<>());
        for(int[] time : times) adj.get(time[0]).add(new int[]{time[1],time[2]});
        int totTime = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(int[] des : adj.get(k)) pq.offer(des);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(k);
        while(!pq.isEmpty())
        {
            int[] cur = pq.poll();
            int des = cur[0];
            int cost = cur[1];
            if(visited.contains(des)) continue;
            totTime = cost;
            visited.add(des);
            for(int[] nei : adj.get(des))
            {
                if(!visited.contains(nei[0])) pq.offer(new int[]{nei[0],nei[1] + cost});
            }
        }
        return visited.size() == n ? totTime : -1;
    }
}
