class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for(char ch : s.toCharArray())
        {
            count[ch - 'a']++;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i = 0 ; i < 26 ; i++)
        {
            if(count[i] != 0) pq.offer(new int[]{count[i],i});
        }
        int[] prev = null;
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty() || prev!=null)
        {
            if(pq.isEmpty() && prev!=null)
            {
                return "";
            }
            int[] curr = pq.poll();
            sb.append((char) (curr[1] + 'a'));
            curr[0]--;
            if(prev!=null)
            {
                pq.offer(prev);
                prev = null;
            }
            if(curr[0] > 0 )
            {
                prev = curr;
            }
        }
        return sb.toString();
    }
}