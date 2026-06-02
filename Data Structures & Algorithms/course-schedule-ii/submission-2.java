class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int[] p : prerequisites)
        {
            adj.computeIfAbsent(p[0], k -> new ArrayList<>()).add(p[1]);
        }
        List<Integer> output = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            if(!dfs(c,adj,visited,cycle,output))
            {
                return new int[0];
            }
        }
        int[] res = new int[output.size()];
        int i = 0;
        for(int temp : output)
        {
            res[i++] = temp;
        }
        return res;
    }
    public boolean dfs(int c , HashMap<Integer,List<Integer>> adj , HashSet<Integer> visited,  HashSet<Integer> cycle, List<Integer> output)
    {
        if(cycle.contains(c)) return false;
        if(visited.contains(c)) return true;
        cycle.add(c);
        if(adj.containsKey(c))
        {
        for(int nei : adj.get(c))
        {
            if(!dfs(nei,adj,visited,cycle,output)) return false;
        }
        }
        cycle.remove(c);
        visited.add(c);
        output.add(c);
        return true;
    }
}
