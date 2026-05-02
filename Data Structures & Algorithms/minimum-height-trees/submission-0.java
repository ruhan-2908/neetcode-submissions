class Solution {
    HashMap<Integer,HashSet<Integer>> adj;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new HashMap<>();
        for(int[] edge : edges)
        {
            adj.putIfAbsent(edge[0],new HashSet<>());
            adj.putIfAbsent(edge[1],new HashSet<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Integer> edgeCount  = new HashMap<>();
        for(Map.Entry<Integer,HashSet<Integer>> entry : adj.entrySet())
        {
            if(entry.getValue().size() == 1)
            {
                q.offer(entry.getKey());
            }
            edgeCount.put(entry.getKey(),entry.getValue().size());
        }
        while(!q.isEmpty())
        {
            if(n<=2)
            {
                return new ArrayList<>(q);
            }
            int len = q.size();
            for(int i=0;i<len;i++)
            {
                int node = q.poll();
                n--;
                for(int nei : adj.get(node))
                {
                    edgeCount.put(nei,edgeCount.get(nei)-1);
                    if(edgeCount.get(nei) == 1) q.offer(nei);                    
                }
            }
        }
        return new ArrayList<>(Arrays.asList(0));
    }
}