class Solution {
    private List<Integer>[] home;
    private HashMap<Integer,Set<Integer>> preMap;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        home = new ArrayList[numCourses];
        preMap = new HashMap<>();
        for(int i = 0 ; i < numCourses ; i++)
        {
            home[i] = new ArrayList<Integer>();
        }
        for(int[] pre : prerequisites)
        {
            home[pre[0]].add(pre[1]);
        }
        for(int i = 0 ; i < numCourses ; i++)
        {
            dfs(i);
        }
        List<Boolean> ans = new ArrayList<>();
        for(int[] q : queries)
        {
            ans.add(preMap.get(q[0]).contains(q[1]));
        }
        return ans;
    }
    public Set<Integer> dfs(int i)
    {
        if(preMap.containsKey(i)) return preMap.get(i);
        Set<Integer> temp = new HashSet<>();
        for(int nei : home[i])
        {
            temp.addAll(dfs(nei));
        }
        temp.add(i);
        preMap.put(i,temp);
        return temp;
    }
}