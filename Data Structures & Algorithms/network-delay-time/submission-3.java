class Pair
{
    int des;
    int val;
    Pair(int des , int val)
    {
        this.des = des;
        this.val = val;
    }
}
class Solution {
    HashMap<Integer,List<Pair>> adj;
    public int networkDelayTime(int[][] times, int n, int k) {
        adj = new HashMap<>();
        for(int[] time : times) adj.computeIfAbsent(time[0],m-> new ArrayList<>()).add(new Pair(time[1],time[2]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        if(adj.containsKey(k))
        {
        for(Pair pair : adj.get(k)) pq.offer( new int[]{pair.des,pair.val});

        }
        HashSet<Integer> set = new HashSet<>();
        set.add(k);
        int totTime = 0;
        while(!pq.isEmpty())
        {
            int[] time = pq.poll();
            if(set.contains(time[0])) continue;
            set.add(time[0]);
            totTime = time[1];
            if(adj.containsKey(time[0]))
            {
                for(Pair nei : adj.get(time[0])) 
                {
                    if(!set.contains(nei))
                    {
                        pq.offer(new int[]{nei.des,nei.val + time[1]});
                    }
                }
            }
        }
        return set.size() == n ? totTime : -1;
    }
}
