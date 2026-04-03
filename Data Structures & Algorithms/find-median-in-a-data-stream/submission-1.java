class MedianFinder {
    ArrayList<Integer> list;
    public MedianFinder() {
        list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        Collections.sort(list);
        if(list.size()%2 == 0)
        {
            double a = (double)list.get((list.size() / 2)- 1);
            double b = (double)list.get((list.size()/2));
            return (double) (a+b)/2;
        }
        else
        {
            return (double) list.get(list.size()/2);
        }
    }
}
