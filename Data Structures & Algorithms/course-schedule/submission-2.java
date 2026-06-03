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
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            if(!dfs(c,visited,cycle,adj)) return false;
        }
        return true;
    }
    public boolean dfs(int c , HashSet<Integer> visited , HashSet<Integer> cycle,HashMap<Integer,List<Integer>> adj)
    {
        if(cycle.contains(c)) return false;
        if(visited.contains(c)) return true;
        cycle.add(c);
        for(int nei : adj.get(c))
        {
            if(!dfs(nei,visited,cycle,adj)) return false;
        }
        cycle.remove(c);
        visited.add(c);
        return true;
    }
}
