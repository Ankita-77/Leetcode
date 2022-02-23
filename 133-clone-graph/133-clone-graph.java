/*
// Definition for a Node.
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
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node clone = new Node(node.val);
        Map<Node, Node> visited = new HashMap<>();
        cloneGraph(node, clone, visited);
        return clone;
    }
    
    private void cloneGraph(Node node, Node clone, Map<Node, Node> visited) {
        if (visited.containsKey(node)) return;
        
        visited.put(node, clone);
        
        for (Node neighbour : node.neighbors) {
            if (!visited.containsKey(neighbour)) {
                cloneGraph(neighbour, new Node(neighbour.val), visited);
            }
            visited.get(node).neighbors.add(visited.get(neighbour));
        }
    }
}