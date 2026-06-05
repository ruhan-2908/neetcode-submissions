class UnionFind
{
    int[] parent;
    int[] rank;
    int components;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
        components = n;
    }

    public int find(int i)
    {
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public boolean union(int n1 ,int n2)
    {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        components--;
        if(rank[p2] > rank[p1])
        {
            int temp = p1;
            p1 = p2;
            p2 = temp;
        }
        parent[p2] = p1;
        rank[p1] += rank[p2];
        return true;
    }

    public int isConnected()
    {
        return components;
    }
}
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        UnionFind uf = new UnionFind(nums.length);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int num = nums[i];
            int f = 2;
            while(f*f <= num)
            {
                if(num % f == 0)
                {
                    if(map.containsKey(f))
                    {
                        uf.union(i,map.get(f));
                    }else
                    {
                        map.put(f,i);
                    }
                }
                while(num % f == 0) num /= f;
                f++;
            }
            if(num > 1)
            {
                if(map.containsKey(num)) uf.union(i,map.get(num));
                else map.put(num,i);
            }
        }
        return uf.isConnected() == 1;
    }
}