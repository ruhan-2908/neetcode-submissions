class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,List<int[]>> adj = new HashMap<>();
        for(int i = 1 ; i <= n ; i++) adj.put(i,new ArrayList<>());
        for(int[] time : times) adj.get(time[0]).add(new int[]{time[1],time[2]});
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int[] nei : adj.get(k)) q.offer(new int[]{nei[0],nei[1]});
        HashSet<Integer> visited = new HashSet<>();
        visited.add(k);
        int total = 0;
        while(!q.isEmpty())
        {
            int[] curr = q.poll();
            if(visited.contains(curr[0])) continue;
            int cost = curr[1];
            total = cost;
            visited.add(curr[0]);
            for(int[] nei : adj.get(curr[0]))
            {
                int nextCost = cost + nei[1];
                if(!visited.contains(nei[0])) 
                {
                    q.offer(new int[]{nei[0],nextCost});
                }
            }
        }

        return visited.size() == n ? total : -1;
    }
}
