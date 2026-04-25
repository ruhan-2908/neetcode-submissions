class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int[] p : prerequisites)
        {
            map.computeIfAbsent(p[0],k->new ArrayList<>()).add(p[1]);
        }
        List<Integer> output = new ArrayList<>();
        Set<Integer> visit = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for(int c =0;c<numCourses ; c++)
        {
            if(!dfs(c,map,output,visit,cycle))
            {
                return new int[0];
            }
        }
        int[] res = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++)
        {
            res[i] = output.get(i);
        }
        return res;
    }
    public boolean dfs(int c, HashMap<Integer,List<Integer>> map , List<Integer> output , Set<Integer> visit, Set<Integer> cycle)
    {
        if(cycle.contains(c)) return false;
        if(visit.contains(c)) return true;
        cycle.add(c);

        for(int pre : map.getOrDefault(c,Collections.emptyList()))
        {
            if(!dfs(pre,map,output,visit,cycle))
            {
                return false;
            }
        }
        cycle.remove(c);
        visit.add(c);
        output.add(c);
        return true;
    }
}
