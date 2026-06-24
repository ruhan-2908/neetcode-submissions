class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> adj = new HashMap<>();
        for(int i = 0 ; i < numCourses ; i++)
        {
            adj.put(i,new ArrayList<>());
        }
        for(int[] p : prerequisites)
        {
            adj.get(p[0]).add(p[1]);
        }
        List<Integer> output = new ArrayList<>();
        HashSet<Integer> cycle = new HashSet<>();
        for(int i = 0 ; i < numCourses ; i++)
        {
            if(!dfs(i,adj,cycle,output)) return new int[0];
        }
        int[] res = new int[output.size()];
        int i = 0;
        for(int o : output) res[i++] = o;
        return res;
    }
    public boolean dfs(int i ,HashMap<Integer,List<Integer>> adj , HashSet<Integer> cycle , List<Integer> output)
    {
        if(!adj.get(i).isEmpty() && adj.get(i).get(0) == -1) return true;
        if(cycle.contains(i)) return false;
        cycle.add(i);
        for(int nei : adj.get(i))
        {
            if(!dfs(nei,adj,cycle,output)) return false;
        }
        cycle.remove(i);
        adj.put(i,new ArrayList<>(Arrays.asList(-1)));
        output.add(i);
        return true;
    }
}
