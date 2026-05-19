class Node
{
    int val;
    Node next;
    Node(int val)
    {
        this.val = val;
        this.next = null;
    }
}
class MyCircularQueue {
    Node start;
    Node end;
    int length;
    int currLength;
    public MyCircularQueue(int k) {
        this.start = null;
        this.end = null;
        length = k;
        currLength = 0;
    }
    
    public boolean enQueue(int value) {
        if(currLength == length) return false;
        if(end == null)
        {
            end = new Node(value);
        }else
        {
            end.next = new Node(value);
            end = end.next;
        }
        if(start == null)
        {
            start = end;
        }
        currLength++;
        return true;
    }
    
    public boolean deQueue() {
        if(start == null) return false;
        start = start.next;
        if(start == null) end = null;
        currLength--;
        return true;
    }
    
    public int Front() {
        if(start == null) return -1;
        return start.val;
    }
    
    public int Rear() {
        if(end == null) return -1;
        return end.val;
    }
    
    public boolean isEmpty() {
        return start == null;
    }
    
    public boolean isFull() {
        return currLength == length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */