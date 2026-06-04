class Solution {
    HashMap<Integer,List<Integer>> adj;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new HashMap<>();
        for(int[] edge : edges)
        {
            adj.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer,List<Integer>> entry : adj.entrySet())
        {
            if(entry.getValue().size() == 1) q.offer(entry.getKey());
        }
        while(!q.isEmpty())
        {
            if(n<=2)
            {
                return new ArrayList<>(q);
            }
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                int node = q.poll();
                n--;
                for(int nei : adj.get(node))
                {
                    adj.get(nei).remove(Integer.valueOf(node));
                    if(adj.get(nei).size() == 1) q.offer(nei);
                }
            }
        }
        return new ArrayList<>(Arrays.asList(0));
    }
}