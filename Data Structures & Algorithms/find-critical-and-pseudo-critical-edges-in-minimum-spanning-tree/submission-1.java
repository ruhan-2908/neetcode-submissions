class UnionFind
{
    int[] parent;
    int[] rank;
    UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    public int find(int i)
    {
        if(parent[i] != i) parent[i] = find(parent[i]);
        return parent[i];
    }

    public boolean union(int n1, int n2)
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
        parent[p2] = p1;
        rank[p1] += rank[p2];
        return true;
    }
}
class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int minCost = 0;
        UnionFind uf = new UnionFind(n);
        for(int i = 0 ;i < edges.length ; i++)
        {
            edges[i] = new int[]{edges[i][0],edges[i][1],edges[i][2],i};   
        }
        Arrays.sort(edges,(a,b) -> a[2]-b[2]);
        for(int i = 0 ; i < edges.length ; i++)
        {
            int[] edge = edges[i];
            if(uf.union(edge[0],edge[1])) minCost += edge[2];
        }
        List<Integer> critical = new ArrayList<>();
        List<Integer> pcritical = new ArrayList<>();
        for(int[] edge : edges)
        {
            uf = new UnionFind(n);
            int cost = 0;
            for(int[] e : edges)
            {
                if(e == edge) continue;
                if(uf.union(e[0],e[1])) cost += e[2];
            }
            if(Arrays.stream(uf.rank).max().getAsInt() != n || cost > minCost)
            {
                critical.add(edge[3]);
                continue;
            }

            uf = new UnionFind(n);
            uf.union(edge[0],edge[1]);
            cost = edge[2];
            for(int[] e : edges)
            {
                if(uf.union(e[0],e[1])) cost += e[2];
            }
            if(cost == minCost) pcritical.add(edge[3]);
        }
        return Arrays.asList(critical,pcritical);
    }
}