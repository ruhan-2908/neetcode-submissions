class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        int prevEnd = intervals[0][1];
        int n = intervals.length;
        int res = 0;
        for(int i =  1; i < n ; i++)
        {
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(start >= prevEnd)
            {
                prevEnd = end;
            }else
            {
                res++;
                prevEnd = Math.min(prevEnd,end);
            }
        }


        return res;
    }
}
