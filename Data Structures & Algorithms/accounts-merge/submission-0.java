public class UnionFind
{
    int[] parent;
    int[] rank;
    public UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = i;
        }
    }
    public int find(int n)
    {
        if(parent[n] != n)
        {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
    public boolean union(int n1, int n2)
    {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else
        {
            parent[p2] = p1;
            rank[p2] += rank[p1];
        }
        return false;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        HashMap<String,Integer> emailToAcc = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            List<String> account = accounts.get(i);
            for(int j=1;j<account.size();j++)
            {
                String email = account.get(j);
                if(emailToAcc.containsKey(email))
                {
                    uf.union(i,emailToAcc.get(email));
                }else
                {
                    emailToAcc.put(email,i);
                }
            }
        }
        HashMap<Integer,List<String>> emailGroup = new HashMap<>();
        for(Map.Entry<String,Integer> entry : emailToAcc.entrySet())
        {
            int leader = uf.find(entry.getValue());
            emailGroup.putIfAbsent(leader,new ArrayList<>());
            emailGroup.get(leader).add(entry.getKey());
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : emailGroup.entrySet())
        {
            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(entry.getKey()).get(0));
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            merged.addAll(emails);
            res.add(merged);
        }
        return res;
    }
}