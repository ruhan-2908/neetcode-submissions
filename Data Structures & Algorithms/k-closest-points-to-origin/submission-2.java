class Pair
{
    int[] i;
    double dist;
    Pair(int[] i , double dist)
    {
        this.i = i;
        this.dist = dist;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.dist,a.dist));
        for(int i = 0 ; i< points.length ; i++)
        {
            int ins = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            double dist = Math.pow(ins,0.5);
            pq.offer(new Pair(points[i],dist));
            if(pq.size() > k)
            {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        for(Pair p : pq)
        {
            ans[i++] = p.i;
        }
        return ans;
    }
}
