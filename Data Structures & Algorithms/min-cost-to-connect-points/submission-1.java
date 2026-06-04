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
        }else if (rank[p2] > rank[p1])
        {
            parent[p1] = p2;
        }else
        {
            rank[p1]++;
            parent[p2]  =p1;
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i = 0 ; i < points.length ; i++)
        {
            for(int j = 1 ; j < points.length ; j++)
            {
                int[] point1 = points[i];
                int[] point2 = points[j];
                int dist = Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
                pq.offer(new int[]{i,j,dist});
            }
        }
        int res = 0;
        UnionFind uf = new UnionFind(points.length);
        while(!pq.isEmpty())
        {
            int[] now = pq.poll();
            if(uf.union(now[0],now[1])) res+=now[2];
        }
        return res;
    }
}
