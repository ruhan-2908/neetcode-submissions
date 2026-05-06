class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,List<String>> adj = new HashMap<>();
        for(List<String> list : tickets)
        {
            adj.putIfAbsent(list.get(0),new ArrayList<>());
        }
        tickets.sort((a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> list : tickets)
        {
            adj.get(list.get(0)).add(list.get(1));
        }
        List<String> res = new ArrayList<>();
        res.add("JFK");

        if(dfs("JFK",res,adj,tickets.size() + 1))
        {
            return res;
        }
        return new ArrayList<>();
    }
    public boolean dfs(String src, List<String> res, HashMap<String,List<String>> adj, int tar)
    {
        if(tar == res.size()) return true;
        if(!adj.containsKey(src)) return false;

        List<String> temp = new ArrayList<>(adj.get(src));
        for(int i =0;i<temp.size();i++)
        {
            String v = temp.get(i);
            adj.get(src).remove(i);
            res.add(v);
            if(dfs(v,res,adj,tar)) return true;
            adj.get(src).add(i,v);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
