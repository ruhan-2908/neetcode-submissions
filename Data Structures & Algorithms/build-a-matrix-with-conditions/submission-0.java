class Solution {
    HashSet<Integer> visit;
    HashSet<Integer> path;
    ArrayList<Integer> order;
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rowOrder = topo(k,rowConditions);
        if(rowOrder == null) return new int[0][0];
        int[] colOrder = topo(k,colConditions);
        if(colOrder == null) return new int[0][0];

        Map<Integer,Integer> valToRow = new HashMap<>();
        for(int i=0;i< rowOrder.length ;i++)
        {
            valToRow.put(rowOrder[i],i);
        }
        Map<Integer,Integer> valToCol = new HashMap<>();
        for(int i=0;i<colOrder.length ;i++)
        {
            valToCol.put(colOrder[i],i);
        }
        int[][] res = new int[k][k];
        for(int i=1;i<=k;i++)
        {
            int r = valToRow.get(i);
            int c = valToCol.get(i);
            res[r][c] = i;
        }
        return res;
    }
    public int[] topo(int k , int[][] edges)
    {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=1;i<=k;i++)
        {
            adj.put(i,new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }

        visit = new HashSet<>();
        path = new HashSet<>();
        order = new ArrayList<>();


        for(int i=1;i<=k;i++)
        {
            if(!visit.contains(i))
            {
                if(!dfs(i,visit,path,order,adj))
                {
                    return null;
                }
            }
        }
        Collections.reverse(order);
        return order.stream().mapToInt(i -> i).toArray();
    }
    public boolean dfs(int i , HashSet<Integer> visit, HashSet<Integer> path, ArrayList<Integer> order,HashMap<Integer,List<Integer>> adj)
    {
        if(path.contains(i)) return false;
        if(visit.contains(i)) return true;

        visit.add(i);
        path.add(i);

        for(int nei : adj.get(i))
        {
            if(!dfs(nei,visit,path,order,adj))
            {
                return false;
            }
        }
        path.remove(i);
        order.add(i);
        return true;
    }
}