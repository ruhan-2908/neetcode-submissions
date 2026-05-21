class Solution {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        int[] check = new int[26];
        for(char ch : s.toCharArray()) check[ch - 'a']++;
        for(int i = 0 ; i < 26 ; i++) 
        {
            if(check[i]!=0) pq.offer(new int[]{check[i],i});
        }
        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        while(!pq.isEmpty() || prev!=null)
        {
            if(pq.isEmpty() && prev!=null) return "";
            int[] curr = pq.poll();
            sb.append((char) (curr[1] + 'a'));
            curr[0]--;
            if(prev!=null) 
            {
                pq.offer(prev);
                prev = null;
            }
            if(curr[0] > 0) prev = curr;
        }
        return sb.toString();
    }
}