class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer,ArrayList<int[]>> adj = new HashMap<>();
        for(int[] time : times)
        {
            int source = time[0];
            int des = time[1];
            int cost = time[2];
            adj.putIfAbsent(source,new ArrayList<>());
            adj.get(source).add(new int[]{des,cost});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        pq.offer(new int[]{0,k});
        int time = 0;
        HashSet<Integer> visited = new HashSet<>();
        while(!pq.isEmpty())
        {
            int[] temp = pq.poll();
            int w1 = temp[0];
            int src = temp[1];

            if(visited.contains(src))
            {
                continue;
            }
            visited.add(src);
            time = w1;

            if(adj.containsKey(src))
            {
                for(int[] node : adj.get(src))
                {
                    int des = node[0];
                    int w2 = node[1];
                    if(!visited.contains(des))
                    {
                        pq.offer(new int[]{w1+w2,des});
                    }
                }
            }
        }
        return visited.size() == n ? time : -1;
    }
}
