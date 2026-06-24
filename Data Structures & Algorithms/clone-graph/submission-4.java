/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> realToReel = new HashMap<>();
    public Node cloneGraph(Node node) {
        return cloneIt(node);
    }
    public Node cloneIt(Node node)
    {
        if(node == null) return node;
        if(realToReel.containsKey(node)) return realToReel.get(node);
        Node newNode = new Node(node.val);
        realToReel.put(node,newNode);
        List<Node> neighbors = new ArrayList<>();
        for(Node nei : node.neighbors)
        {
            neighbors.add(cloneIt(nei));
        }
        newNode.neighbors = neighbors;
        return newNode;
    }
}