class Solution {
    HashMap<Integer,Set<Integer>> adj;
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = new HashMap<>();
        for(int[] edge : edges)
        {
            adj.computeIfAbsent(edge[0],k-> new HashSet<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1],k-> new HashSet<>()).add(edge[0]);
        }   
        HashMap<Integer,Integer> edgeCnt = new HashMap<>();
        for(Map.Entry<Integer,Set<Integer>> entry : adj.entrySet())
        {
            edgeCnt.put(entry.getKey(),entry.getValue().size());
        }
        Queue<Integer> q = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : edgeCnt.entrySet())
        {
            if(entry.getValue() == 1) q.offer(entry.getKey());
        }
        while(!q.isEmpty())
        {
            if(n<=2) return new ArrayList<>(q);
            int size = q.size();
            for(int i = 0 ; i < size ; i++)
            {
                int leaf = q.poll();
                n--;
            for(int nei : adj.get(leaf))
            {
                edgeCnt.put(nei,edgeCnt.get(nei) - 1);
                if(edgeCnt.get(nei) == 1) q.offer(nei);
            }
            }
        }
        return new ArrayList<>(Arrays.asList(0));
    }
}