class UnionFind
{
    int[] parent;
    int[] rank;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ;i < n ; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int i)
    {
        if(parent[i] != i)
        {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }
    public boolean union(int n1 , int n2)
    {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
        }
        else if( rank[p2] > rank[p1])
        {
            parent[p1]  =p2;
        }
        else
        {
            rank[p1]++;
            parent[p2] = p1;
        }
        return true;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        UnionFind uf = new UnionFind(n);
        HashMap<String,Integer> emailToAcc = new HashMap<>();
        for(int i = 0; i < n ; i++)
        {
            List<String> account = accounts.get(i);
            for(int j = 1; j < account.size() ; j++)
            {
                if(emailToAcc.containsKey(account.get(j)))
                {       
                    uf.union(i,emailToAcc.get(account.get(j)));
                }else
                {
                    emailToAcc.put(account.get(j),i);
                }
            }
        }
        HashMap<Integer,List<String>> accToEmail = new HashMap<>();
        for(Map.Entry<String,Integer> entry : emailToAcc.entrySet())
        {
            int leader = uf.find(entry.getValue());
            accToEmail.computeIfAbsent(leader,k -> new ArrayList<>()).add(entry.getKey());
        }
        List<List<String>> merged = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : accToEmail.entrySet())
        {
            List<String> merge = new ArrayList<>();
            merge.add(accounts.get(entry.getKey()).get(0));
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            merge.addAll(emails);
            merged.add(merge);
        }
        return merged;
    }
}