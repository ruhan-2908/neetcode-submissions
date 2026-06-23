class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b) -> a[0]-b[0]);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        PriorityQueue<long[]> endTimes = new PriorityQueue<>((a,b) ->
                                                            a[0]!=b[0] ? Long.compare(a[0],b[0]) : Long.compare(a[1],b[1]));
        int[] times = new int[n];
        for(int i = 0 ; i < n ; i++) rooms.offer(i);
        int i = 0;
        while(i < meetings.length)
        {
            int[] curr = meetings[i];

            while(!endTimes.isEmpty() && endTimes.peek()[0] <= curr[0])
            {
                int room = (int) endTimes.poll()[1];
                rooms.offer(room);
            }

            if(rooms.isEmpty())
            {
                long[] earliest = endTimes.poll();
                int room = (int) earliest[1];
                curr[1] = (int)(earliest[0] + (curr[1] - curr[0]));
                rooms.offer(room);
            }
            int room = rooms.poll();
            endTimes.offer(new long[]{curr[1],room});
            times[room]++;
            i++;
        }

        int max = 0;
        for(int t = 0 ; t < times.length ; t++) 
        {
            if(times[max] < times[t])
            {
                max = t;
            }
        }

        return max;
    }
}