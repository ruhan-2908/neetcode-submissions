public class UnionFind
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
    public int find(int a)
    {
        if(parent[a] != a)
        {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    public boolean union(int a , int b)
    {
        int p1 = find(a);
        int p2 = find(b);

        if(p1 == p2) return false;

        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
        }else if ( rank[p2] > rank[p1])
        {
            parent[p1] = p2;
        }else
        {
            parent[p2] = p1;
            rank[p1]++;
        }

        return true;
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n -1) return false;
        UnionFind uf = new UnionFind(n);
        for(int[] edge : edges)
        {
            if(!uf.union(edge[0],edge[1]))
            {
                return false;
            }
        }
        return true;
    }
}
