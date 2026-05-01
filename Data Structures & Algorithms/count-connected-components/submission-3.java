public class UnionFind
{
    int[] parent;
    int[] rank;
    public UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i =  0 ; i < n ; i++)
        {
            parent[i] = i;
            rank[i] = i;
        }
    }
    public int find(int n)
    {
        if(parent[n]!=n)
        {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
    public boolean union(int n1, int n2)
    {
        int p1 = find(parent[n1]);
        int p2 = find(parent[n2]);

        if(p1 == p2) return false;
        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
        }else if ( rank[p1] < rank[p2])
        {
            parent[p1] = p2;
        }
        else
        {
            parent[p2] = p1;
            rank[p1]++;
        }
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        int res = n;
        for(int[] edge : edges)
        {
            if(uf.union(edge[0],edge[1])) res--;
        }
        return res;
    }
}
