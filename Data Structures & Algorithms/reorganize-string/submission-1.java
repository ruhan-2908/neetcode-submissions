class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray())
        {
            freq[ch - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i =0;i<26;i++)
        {
            if(freq[i]!=0) pq.offer(new int[]{freq[i],i});
        }

        int[] prev = null;
        while(!pq.isEmpty() || prev!= null)
        {
            if(prev!=null && pq.isEmpty()) return "";

            int[] curr = pq.poll();
            sb.append((char) (curr[1] + 'a')); 
            curr[0]--;
            if(prev!=null)
            {
                pq.offer(prev);
                prev = null;
            }
            if(curr[0] > 0)
            {
                prev = curr;
            }
        }

        return sb.toString();
    }
}