class Node
{
    int value; // here we store only the key but the term because of some shitty reason , kept as value
    Node prev;
    Node next;
    Node(int value)
    {
        this.value = value;
    }
}
class DoublyLinkedList
{
    Node left;
    Node right;
    HashMap<Integer,Node> map;
    DoublyLinkedList()
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

    public void pop(int val)
    {
        if(map.containsKey(val))
        {
            Node node = map.get(val);
            Node left = node.prev;
            left.next = node.next;
            node.next.prev = left;
            map.remove(val);
        }
    }

    public int popLeft()
    {
        int res = this.left.next.value;
        pop(res);
        return res;
    }
    
    public void update(int val)
    {
        pop(val);
        pushRight(val);
    }
    public void pushRight(int value)
    {
        Node temp = new Node(value);
        map.put(value,temp);
        Node lef = right.prev;
        lef.next =temp;
        temp.next = right;
        right.prev = temp;
        temp.prev = lef;
    }
}
class LFUCache {
    int capacity;
    int lfuCount;
    HashMap<Integer,DoublyLinkedList> listMap;
    HashMap<Integer,Integer> countMap;
    HashMap<Integer,Integer> valueMap;
    public LFUCache(int capacity) {
        this.listMap = new HashMap<>();
        this.countMap = new HashMap<>();
        this.valueMap = new HashMap<>();
        this.capacity = capacity;
        this.lfuCount = 0;
    }
    
    public void counter(int key)
    {
        int count = countMap.get(key);
        countMap.put(key,count+1);

        listMap.putIfAbsent(count, new DoublyLinkedList());
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
        if(capacity == 0 ) return;
        if(!valueMap.containsKey(key) && valueMap.size() == capacity)
        {
            int lfu = listMap.get(lfuCount).popLeft();
            countMap.remove(lfu);
            valueMap.remove(lfu);
        }
        valueMap.put(key,value);
        countMap.putIfAbsent(key,0);
        counter(key);
        lfuCount = Math.min(lfuCount, countMap.get(key));
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */