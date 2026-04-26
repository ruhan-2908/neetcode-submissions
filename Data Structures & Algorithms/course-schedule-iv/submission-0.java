class Solution {
    private List<Integer>[] home;
    private HashMap<Integer,Set<Integer>> preMap;
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        preMap = new HashMap<>();
        home = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            home[i] = new ArrayList<Integer>();
        }
        for(int[] p : prerequisites)
        {
            home[p[0]].add(p[1]);
        }
        for(int i = 0 ; i < numCourses ; i++)
        {
            dfs(i);
        }
        List<Boolean> list = new ArrayList<>();
        for(int[] q : queries)
        {
            list.add(preMap.get(q[0]).contains(q[1]));
        }
        return list;
    }
    public Set<Integer> dfs(int c)
    {
        if(preMap.containsKey(c)) return preMap.get(c);
        Set<Integer> temp = new HashSet<>();
        for(int p : home[c])
        {
            temp.addAll(dfs(p));
        }
        temp.add(c);
        preMap.put(c,temp);
        return temp;
    }
}