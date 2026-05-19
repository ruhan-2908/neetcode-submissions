class Node
{
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key , int value)
    {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
class LRUCache {
    int cap;
    Node left;
    Node right;
    HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        cap = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        map = new HashMap<>();
        left.next = right;
        right.prev = left;
    }
    public void remove(Node node)
    {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }
    public void insert(Node node)
    {   
        Node prev = right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = right;
        right.prev = node;
    }
    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            remove(map.get(key));
        }
        Node node = new Node(key,value);
        insert(node);
        map.put(key,node);
        if(map.size() > cap)
        {
            Node lru = left.next;
            remove(lru);
            map.remove(lru.key);
        }
    }
}
