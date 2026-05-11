class UnionFind
{
    int[] parent;
    int[] rank;
    int n;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        this.n = n;
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int n)
    {
        if(n!= parent[n])
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
        n--;
        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else
        {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
    public boolean isConnected()
    {
        return n == 1;
    }
}
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n = nums.length;
        UnionFind uf = new UnionFind(n);
        HashMap<Integer,Integer> indexToFactor = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int num = nums[i];
            int f = 2;
            while(f*f <= num)
            {
                if(num % f == 0)
                {
                    if(indexToFactor.containsKey(f))
                    {
                        uf.union(i,indexToFactor.get(f));
                    }else
                    {
                        indexToFactor.put(f,i);
                    }
                    while(num % f == 0)
                    {
                        num = num / f;
                    }
                }
                f++;
            }
            if(num > 1)
                {
                    if(indexToFactor.containsKey(num))
                    {
                        uf.union(indexToFactor.get(num),i);
                    }else
                    {
                        indexToFactor.put(num,i);
                    }
                }
        }

        return uf.isConnected();
    }
}