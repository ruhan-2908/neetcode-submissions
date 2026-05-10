class UnionFind
{
    int[] parent;
    int[] rank;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int n )
    {
        if(n != parent[n])
        {
            parent[n] = find(parent[n]);
        }
        return parent[n];
    }
    public boolean union(int n1 , int n2)
    {
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 == p2) return false;
        
        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }else
        {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
public class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges   (int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        List<int[]> edgeList = new ArrayList<>();
        for(int i=0;i<edges.length;i++)
        {
            edgeList.add(new int[]{edges[i][0],edges[i][1],edges[i][2],i});
        }
        edgeList.sort((a,b) -> a[2] - b[2]);
        
        int mst = 0;
        for(int[] edge : edgeList)
        {
            if(uf.union(edge[0],edge[1]))
            {
                mst += edge[2];
            }
        }
        List<Integer> c = new ArrayList<>();
        List<Integer> p = new ArrayList<>();
        
        for(int[] edge : edgeList)
        {
            UnionFind ufWithout = new UnionFind(n);
            int ufWi = 0;
            for(int[] e : edgeList)
            {
                if(edge[3] != e[3] && ufWithout.union(e[0],e[1]))
                {
                    ufWi += e[2];
                }
            }
            if(Arrays.stream(ufWithout.rank).max().getAsInt() != n || ufWi > mst)
            {
                c.add(edge[3]);
                continue;
            }
            
            UnionFind ufw = new UnionFind(n);
            ufw.union(edge[0],edge[1]);
            int ufwe = edge[2];
            for(int[] e : edgeList)
            {
                if(ufw.union(e[0],e[1]))
                {
                    ufwe += e[2];
                }
            }
            if(mst == ufwe)
            {
                p.add(edge[3]);
            }
        }
        return Arrays.asList(c,p);
    }
}