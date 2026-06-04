class UnionFind
{
    int[] parent;
    int[] rank;
    int components;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for(int i = 0 ; i < n ; i++)
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
    
    public boolean union(int n1, int n2)
    {
        int p1 = find(n1);
        int p2 = find(n2);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
        }else if(rank[p2] > rank[p1])
        {
            parent[p1] = p2;
        }else
        {
            rank[p1]++;
            parent[p2] = p1;
        }
        components--;
        return true;
    }

}
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges) uf.union(edge[0],edge[1]);
        return uf.components;
    }
}
