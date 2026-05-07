class DSU
{
    int[] parent;
    int[] rank;
    DSU(int n)
    {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            rank[i] = 0;
        }
    }
    public int find(int n)
    {
        if(parent[n] != n)
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
        if(rank[p1] > rank[p2])
        {
            parent[p2] = p1; 
        }else if( rank[p1] < rank[p2])
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
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> list = new ArrayList<>();
        DSU uf = new DSU(n);
        for(int i =0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int[] point1 = points[i];
                int[] point2 = points[j];
                int dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                list.add(new int[]{dist,i,j});
            }
        }
        list.sort((a,b) -> Integer.compare(a[0],b[0]));
        int res = 0;
        for(int[] edge : list){
            if(uf.union(edge[1],edge[2]))
            {
                res += edge[0];
            }
        }
        return res;
    }
}
