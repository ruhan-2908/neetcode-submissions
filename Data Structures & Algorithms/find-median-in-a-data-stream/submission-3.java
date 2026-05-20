class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a,b) -> b-a);
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        if(maxHeap.size() - minHeap.size() > 1 || (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()))
        {
            minHeap.offer(maxHeap.poll());
        }
        if(minHeap.size() - maxHeap.size() > 1)
        {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
        {
            return (double) ( (maxHeap.peek() + minHeap.peek()) / 2.0 );
        }
        else if(maxHeap.size() > minHeap.size())
        {
            return (double) (maxHeap.peek());
        }else
        {
            return (double) (minHeap.peek());
        }
    }
}
