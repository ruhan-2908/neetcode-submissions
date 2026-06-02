class Solution {
    HashMap<Integer,List<Integer>> adj;
    HashSet<Integer> set;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adj = new HashMap<>();
        for(int c = 0 ; c < numCourses ; c++) adj.put(c,new ArrayList<>());
        for(int[] p : prerequisites)
        {
            adj.get(p[0]).add(p[1]);
        }
        set = new HashSet<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            if(!dfs(c)) return false;
        }
        return true;
    }
    public boolean dfs(int c)
    {
        if(set.contains(c)) return false;
        if(adj.get(c).isEmpty()) return true;

        set.add(c);
        for(int nei : adj.get(c))
        {
            if(!dfs(nei)) return false;
        }
        set.remove(c);
        adj.put(c,new ArrayList<>());
        return true;
    }
}
