class Node
{

    int key;
    int val;
    Node prev;
    Node next;

    Node(int key,int val)
    {
        this.key = key;
        this.val = val;
    }

}
class LRUCache {

    Node left;
    Node right;
    int cap;
    int size = 0;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        left = new Node(0,0);
        right = new Node(0,0);
        left.next = right;
        right.prev = left;
        this.size = 0;
    }
    
    public void remove(Node node)
    {
        Node toLeft = node.prev;
        Node toRight = node.next;
        toLeft.next = toRight;
        toRight.prev = toLeft;
    }

    public void insert(Node node)
    {
        Node toLeft = right.prev;
        toLeft.next = node;
        node.prev = toLeft;
        right.prev = node;
        node.next = right;
    }

    public int get(int key) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            size--;
            remove(map.get(key));
        }
        Node newNode = new Node(key,value);
        insert(newNode);
        map.put(key,newNode);
        size++;
        if(size > cap)
        {
            Node lru = left.next;
            map.remove(lru.key);
            size--;
            remove(lru);
        }
    }
}
