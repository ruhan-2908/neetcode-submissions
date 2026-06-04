class UnionFind
{
    int[] parent;
    int[] rank;
    UnionFind(int n)
    {
        parent = new int[n+1];
        rank = new int[n+1];
        for(int i = 1 ; i <= n;i++)
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
        }else if ( rank[p2] > rank[p1])
        {
            parent[p1] = p2;
        }else
        {
            rank[p1]++;
            parent[p2] = p1;
        }
        return true;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        for(int[] edge : edges)
        {
            if(!uf.union(edge[0],edge[1]))
            {
                return edge;
            }
        }
        return new int[0];
    }
}
