class Solution {
    HashMap<String,List<String>> adj;
    public List<String> findItinerary(List<List<String>> tickets) {
        adj = new HashMap<>();
        Collections.sort(tickets,(a,b) -> a.get(1).compareTo(b.get(1)));
        for(List<String> ticket : tickets)
        {
            adj.computeIfAbsent(ticket.get(0), k -> new ArrayList<>()).add(ticket.get(1));
        }
        List<String> res =new ArrayList<>();
        res.add("JFK");
        if(dfs("JFK",res,adj,tickets.size() + 1))
        {
            return res;
        }
        return new ArrayList<>();
    }
    public boolean dfs(String src, List<String> res , HashMap<String,List<String>> adj, int tar)
    {
        if(res.size() == tar) return true;
        if(!adj.containsKey(src)) return false;
        List<String> temp = adj.get(src);
        for(int i = 0 ;i < temp.size() ; i++)
        {
            String nei = temp.get(i);
            res.add(nei);
            adj.get(src).remove(i);
            if(dfs(nei,res,adj,tar)) return true;
            adj.get(src).add(i,nei);
            res.remove(res.size() - 1);
        }
        return false;
    }
}
