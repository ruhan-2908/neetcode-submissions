class Pair
{
    String deno;
    double val;
    Pair(String deno , double val)
    {
        this.deno = deno;
        this.val = val;
    }
}
class Solution {
    HashMap<String,List<Pair>> adj = new HashMap<>();
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int valIdx = 0;
        for(List<String> eq : equations)
        {
            double v = values[valIdx++];
            adj.computeIfAbsent(eq.get(0),k-> new ArrayList<>()).add(new Pair(eq.get(1),v));
            adj.computeIfAbsent(eq.get(1),k-> new ArrayList<>()).add(new Pair(eq.get(0), (double) (1.0 / v)));
        }
        double[] ans = new double[queries.size()];
        valIdx = 0;
        for(List<String> q : queries)
        {
            Set<String> visited = new HashSet<>();
            double[] anso = dfs(adj,q.get(0),q.get(1),1.0,visited);
            ans[valIdx++] = anso[1];
        }
        return ans;
    }
    public double[] dfs(HashMap<String,List<Pair>> adj, String num , String den, double value,Set<String> visited)
    {
        if(!adj.containsKey(num)) return new double[]{0.0,-1.0};
        if(num.equals(den)) return new double[]{1.0,value};
        visited.add(num);
        List<Pair> possibleDen = adj.get(num);
        for(Pair p : possibleDen)
        {
            if(!visited.contains(p.deno))
            {
                double[] temp = dfs(adj,p.deno,den,value * p.val,visited);
                if(temp[0] == 1.0) return temp;
            }
        }
        return new double[]{0.0,-1.0};
    }
}