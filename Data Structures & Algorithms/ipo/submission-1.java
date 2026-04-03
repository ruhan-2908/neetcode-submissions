class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Integer[] indices = new Integer[n];
        for(int i = 0 ; i< n ; i++)
        {
            indices[i] = i;
        }
        Arrays.sort(indices, (a,b) -> Integer.compare(capital[a],capital[b]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b - a );
        int idx = 0;
        for(int i =0;i<k;i++)
        {
            while(idx < n && capital[indices[idx]] <= w)
            {
                maxHeap.offer(profits[indices[idx]]);
                idx++;
            }
            if(maxHeap.isEmpty()) break;
            w += maxHeap.poll();
        }


        return w;
    }
}