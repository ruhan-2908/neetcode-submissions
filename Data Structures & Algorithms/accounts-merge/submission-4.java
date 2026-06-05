class UnionFind
{
    int[] parent;
    int[] rank;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ;  i < n ; i++ )
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

        if(rank[p2] > rank[p1])
        {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        parent[p1] = p2;
        rank[p1] += rank[p2];
        return true;
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        HashMap<String,Integer> accToIdx = new HashMap<>();
        for(int i = 0 ; i < accounts.size() ; i++)
        {
            List<String> list = accounts.get(i);
            for(int j = 1 ; j < list.size() ; j++)
            {
                String email = list.get(j);
                if(accToIdx.containsKey(email))
                {
                    uf.union(i,accToIdx.get(email));
                }else
                {
                    accToIdx.put(email,i);
                }
            }
        }
        HashMap<Integer,List<String>> idxToEmails = new HashMap<>();
        for(Map.Entry<String,Integer> entry : accToIdx.entrySet())
        {
            int leader = uf.find(entry.getValue());
            idxToEmails.computeIfAbsent(leader, k-> new ArrayList<>()).add(entry.getKey());
        }
        List<List<String>> merged = new ArrayList<>();
        for(Map.Entry<Integer,List<String>> entry : idxToEmails.entrySet())
        {
            List<String> cur = new ArrayList<>();
            cur.add(accounts.get(entry.getKey()).get(0));
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            cur.addAll(emails);
            merged.add(cur);
        }
        return merged;
    }
}