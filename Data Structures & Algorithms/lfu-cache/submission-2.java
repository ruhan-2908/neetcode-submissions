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
class DoublyLinkedList
{
    HashMap<Integer,Node> map;
    Node left;
    Node right;
    DoublyLinkedList()
    {
        this.map = new HashMap<>();
        left = new Node(0);
        right = new Node(0);
        left.next = right;
        right.prev = left;
    }

    public int length()
    {
        return map.size();
    }

    public int popLeft()
    {
        int res = this.left.next.key;
        pop(res);
        return res;
    }
    
    public void pop(int key)
    {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            Node lefto = node.prev;
            lefto.next = node.next;
            node.next.prev = lefto;
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
        Node newNode = new Node(key);
        Node node = right.prev;
        node.next = newNode;
        right.prev = newNode;
        newNode.prev = node;
        newNode.next = right;
        map.put(key,newNode);
    }
}
class LFUCache {
    int lfuCount;
    int capacity;
    HashMap<Integer,Integer> valueMap; // key -> value
    HashMap<Integer,Integer> countMap; // key -> count
    HashMap<Integer,DoublyLinkedList> listMap; // count -> LRU ( key -> node)
    public LFUCache(int capacity) {
        listMap = new HashMap<>();
        countMap = new HashMap<>();
        valueMap = new HashMap<>();
        this.capacity = capacity;
        this.lfuCount = 0;
    }
    
    public void counter(int key)
    {
        int count = countMap.get(key);
        countMap.put(key,count+1);


        listMap.putIfAbsent(count,new DoublyLinkedList());
        listMap.get(count).pop(key);


        listMap.putIfAbsent(count+1,new DoublyLinkedList());
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
            countMap.remove(lfu);
            valueMap.remove(lfu);
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