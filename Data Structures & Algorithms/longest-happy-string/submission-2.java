class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder res = new StringBuilder();
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((as,bs) -> bs[0] - as[0]);
        if(a>0) maxHeap.offer(new int[]{a,0});
        if(b>0) maxHeap.offer(new int[]{b,1});
        if(c>0) maxHeap.offer(new int[]{c,2});

        while(!maxHeap.isEmpty())
        {
            int[] first = maxHeap.poll();
            if(res.length() > 1 && (char) (first[1]+'a') == res.charAt(res.length()-1) && 
            (char)(first[1] + 'a') == res.charAt(res.length() - 2))
            {
                if(maxHeap.isEmpty()) break;
                int[] sec = maxHeap.poll();
                res.append((char)(sec[1] +'a'));
                sec[0]--;
                if(sec[0]>0) maxHeap.offer(sec);
                maxHeap.offer(first);
            }else
            {
                res.append((char) (first[1] + 'a'));
                first[0]--;
                if(first[0] > 0 ) maxHeap.offer(first);
            }
        }

        return res.toString();
    }
}