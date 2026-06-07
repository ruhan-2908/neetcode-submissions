class Node
{
    int key;
    Node prev;
    Node next;

    Node(int key)
    {
        this.key = key;
    }
}
class DLL
{
    HashMap<Integer,Node> map;
    Node left;
    Node right;

    DLL()
    {
        this.left = new Node(0);
        this.right = new Node(0);
        left.next = right;
        right.prev = left;
        map = new HashMap<>(); 
    }

    public int length()
    {
        return map.size();
    }

    public int popLeft()
    {
        int key = this.left.next.key;
        pop(key);
        return key;
    }

    public void pop(int key)
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            Node toLeft = node.prev;
            Node toRight = node.next;
            toLeft.next = toRight;
            toRight.prev = toLeft;
            map.remove(key);
        }
    }

    public void update(int key)
    {
        pop(key);
        pushRight(key);
    }

    public void pushRight(int key)
    {
        Node node = new Node(key);
        Node toLeft = right.prev;
        toLeft.next = node;
        node.prev = toLeft;
        right.prev = node;
        node.next = right;
        map.put(key,node);
    }
}
class LFUCache {
    HashMap<Integer,Integer> valueMap;
    HashMap<Integer,Integer> countMap;
    HashMap<Integer,DLL> listMap;
    int capacity;
    int lfuCount;
    public LFUCache(int capacity) {
        valueMap = new HashMap<>();
        countMap = new HashMap<>();
        listMap = new HashMap<>();
        this.capacity = capacity;
        this.lfuCount = 0;
    }
    
    public void counter(int key)
    {
        int count = countMap.get(key);
        countMap.put(key,count+1);

        listMap.putIfAbsent(count,new DLL());
        listMap.get(count).pop(key);

        listMap.putIfAbsent(count+1,new DLL());
        listMap.get(count+1).pushRight(key);

        if(count == lfuCount && listMap.get(count).length() == 0) lfuCount++;
    }

    public int get(int key) {
        if(!valueMap.containsKey(key)) return -1;
        counter(key);
        return valueMap.get(key);
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        if(!valueMap.containsKey(key) && valueMap.size() == capacity)
        {
            int lfu = listMap.get(lfuCount).popLeft();
            valueMap.remove(lfu);
            countMap.remove(lfu);
        }
        valueMap.put(key,value);
        countMap.putIfAbsent(key,0);
        counter(key);
        lfuCount = Math.min(lfuCount,countMap.get(key));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */