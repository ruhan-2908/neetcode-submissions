class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((as,bs) -> bs[0] - as[0]);
        if(a>0) pq.offer(new int[]{a,0});
        if(b>0) pq.offer(new int[]{b,1});
        if(c>0) pq.offer(new int[]{c,2});
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            int[] first = pq.poll();
            char ch = (char)(first[1] + 'a');
            if(sb.length() > 1 && ch == sb.charAt(sb.length() - 1) && ch == sb.charAt(sb.length() - 2))
            {
                if(pq.isEmpty()) break;
                int[] second = pq.poll();
                sb.append((char) (second[1] + 'a'));
                second[0]--;
                if(second[0]>0) pq.offer(second);
                pq.offer(first);
            }else
            {
                sb.append((char) (first[1] + 'a'));
                first[0]--;
                if(first[0] > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }
}