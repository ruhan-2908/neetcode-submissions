class Solution {
    HashMap<Integer,List<Integer>> map = new HashMap<>();
    HashSet<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int c=0;c<numCourses;c++)
        {
            map.put(c,new ArrayList<>());
        }
        for(int[] p : prerequisites)
        {
            map.get(p[0]).add(p[1]);
        }
        for(int c =0;c<numCourses;c++)
        {
            if(!dfs(c)) return false;
        }
        return true;
    }
    public boolean dfs(int c)
    {
        if(visiting.contains(c)) return false;
        if(map.get(c).isEmpty()) return true;

        visiting.add(c);
        for(int p : map.get(c))
        {
            if(!dfs(p)) return false;
        }
        visiting.remove(c);
        map.put(c,new ArrayList<>());
        return true;
    }
}
