class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            adj.put(c,new ArrayList<>());
        }
        for(int[] p : prerequisites)
        {
            adj.get(p[0]).add(p[1]);
        }
        List<Integer> output = new ArrayList<>();
        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> cycle = new HashSet<>();
        for(int c = 0 ; c < numCourses ; c++)
        {
            if(!dfs(c,cycle,output,adj,visited)) return new int[0];
        }
        int[] res = new int[output.size()];
        int r = 0;
        for(int i : output)
        {
            res[r++]  = i;
        }
        return res;
    }
    public boolean dfs(int c ,HashSet<Integer> cycle, List<Integer> output, HashMap<Integer,List<Integer>> adj,HashSet<Integer> visited)
    {
        if(cycle.contains(c)) return false;
        if(visited.contains(c)) return true;
        cycle.add(c);
        for(int nei : adj.get(c))
        {
            if(!dfs(nei,cycle,output,adj,visited)) return false;
        }
        cycle.remove(c);
        output.add(c);
        visited.add(c);
        return true;
    }
}
