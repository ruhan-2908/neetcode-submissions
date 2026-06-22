class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int i = 0 ;
        while(i < n)
        {
            int end = intervals[i][1];
            int j = i + 1;
            while(j < n && end >= intervals[j][0])
            {
                end = Math.max(end,intervals[j][1]);
                j++;
            }
            ans.add(new int[]{intervals[i][0],end});
            i = j ;
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}
