class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int[] rows = topo(rowConditions,k);
        if(rows == null) return new int[0][0];
        int[] cols = topo(colConditions,k);
        if(cols == null) return new int[0][0];
        HashMap<Integer,Integer> valToRow = new HashMap<>();
        for(int i = 0 ; i < rows.length ; i++)
        {
            valToRow.put(rows[i],i);
        }
        HashMap<Integer,Integer> valToCol = new HashMap<>();
        for(int i = 0 ; i < cols.length ; i++)
        {
            valToCol.put(cols[i],i);
        }        

        int[][] ans = new int[k][k];
        for(int i = 1 ; i <= k ; i++)
        {
            int row = valToRow.get(i);
            int col = valToCol.get(i);
            ans[row][col] = i;
        }
        return ans;
    }
    public int[] topo(int[][] conditions, int k)
    {
        HashMap<Integer,HashSet<Integer>> adj = new HashMap<>();
        for(int i = 1 ; i <= k ; i++)
        {
            adj.put(i,new HashSet<>());
        }

        for(int[] cond : conditions)
        {
            adj.get(cond[0]).add(cond[1]);
        }

        HashSet<Integer> cycle = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();
        List<Integer> output = new ArrayList<>();

        for(int i = 1 ; i <= k ; i++)
        {
            if(!dfs(i,cycle,visited,output,adj)) return null;
        }

        Collections.reverse(output);
        return output.stream().mapToInt(i->i).toArray();
    }
    public boolean dfs(int i , HashSet<Integer> cycle , HashSet<Integer> visited, List<Integer> output,HashMap<Integer,HashSet<Integer>> adj)
    {
        if(cycle.contains(i)) return false;
        if(visited.contains(i)) return true;
        cycle.add(i);
        for(int nei : adj.get(i))
        {
            if(!dfs(nei,cycle,visited,output,adj)) return false;
        }
        cycle.remove(i);
        visited.add(i);
        output.add(i);
        return true;
    }
}