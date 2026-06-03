class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            adj.put(c,new ArrayList<>());
        }
        for(int[] p : prerequisites)
        {
            adj.get(p[0]).add(p[1]);
        }
        HashSet<Integer> cycle = new HashSet<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            if(!dfs(c,adj,cycle)) return false;
        }
        return true;
    }
    public boolean dfs(int c , HashMap<Integer,List<Integer>> adj, HashSet<Integer> cycle)
    {
        if(cycle.contains(c)) return false;
        if(adj.get(c).isEmpty()) return true;
        cycle.add(c);
        for(int nei : adj.get(c))
        {
            if(!dfs(nei,adj,cycle)) return false;
        }
        cycle.remove(c);
        adj.put(c,new ArrayList<>());
        return true;
    }
}
