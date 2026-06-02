class UnionFind
{
    int[] parent;
    int[] rank;
    UnionFind(int n)
    {
        parent =new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int r)
    {
        if(parent[r] != r)
        {
            parent[r] = find(parent[r]);
        }
        return parent[r];
    }
    public boolean union(int u , int v)
    {
        int i = find(u);
        int j = find(v);
        if(i == j) return false;

        if(rank[i] > rank[j])
        {
            parent[j] = i;
        }else if( rank[i] < rank[j])
        {
            parent[i] = j;
        }else
        {
            rank[i]++;
            parent[j] = i;
        }
        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges)
        {
            if(!uf.union(edge[0],edge[1])) return false;
        }
        return edges.length == n - 1 ? true : false;
    }
}
