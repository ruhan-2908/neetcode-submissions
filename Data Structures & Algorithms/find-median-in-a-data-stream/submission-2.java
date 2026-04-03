class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size() - minHeap.size() > 1 || !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek())
        {
            int temp = maxHeap.poll();
            minHeap.offer(temp);
        }
        if(minHeap.size() - maxHeap.size()  > 1)
        {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size() == maxHeap.size())
        {
            return (double) (minHeap.peek() + maxHeap.peek())/2;
        }else if ( minHeap.size() > maxHeap.size())
        {
            return (double) minHeap.peek();
        }else
        {
            return (double) maxHeap.peek();
        }
    }
}
