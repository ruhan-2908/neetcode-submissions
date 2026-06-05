class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topo(k,rowConditions);
        if(rowOrder == null) return new int[0][0];
        int[] colOrder = topo(k,colConditions);
        if(colOrder == null) return new int[0][0];
        HashMap<Integer,Integer> valToRow = new HashMap<>();
        for(int i =0 ; i < rowOrder.length ; i++) valToRow.put(rowOrder[i],i);
        HashMap<Integer,Integer> valToCol = new HashMap<>();
        for(int i =0 ; i < colOrder.length ; i++) valToCol.put(colOrder[i],i);
        int[][] ans = new int[k][k];
        for(int i = 1 ; i <= k ; i++)
        {
            int row = valToRow.get(i);
            int col = valToCol.get(i);
            ans[row][col] = i;
        }
        return ans;
    }
    public int[] topo(int n , int[][] edges)
    {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i = 1 ; i  <= n ; i++) adj.putIfAbsent(i,new ArrayList<>());
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        List<Integer> order = new ArrayList<>();
        for(int i = 1 ;  i <= n ; i++)
        {
            if(!visited.contains(i))
            {
                if(!dfs(i,adj,visited,cycle,order))
                {
                    return null;
                }
            }
        }
        Collections.reverse(order);
        return order.stream().mapToInt(i -> i).toArray();
    }
    public boolean dfs(int src, HashMap<Integer,List<Integer>> adj , HashSet<Integer> visited, HashSet<Integer> cycle, List<Integer> order)
    {
        if(cycle.contains(src)) return false;        
        if(visited.contains(src)) return true;
        visited.add(src);
        cycle.add(src);
        for(int nei : adj.get(src))
        {
            if(!dfs(nei,adj,visited,cycle,order))
            {
                return false;
            }
        }
        cycle.remove(src);
        order.add(src);
        return true;
    }
}