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
import java.util.*;
class Solution {
        // HashMap to keep track of already clone node (old node  -> new Node) 
        private HashMap<Node , Node> oldToNew = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        return dfs(node);
    }
    private Node dfs(Node node) {
        // if the Node is already cloned return the cloned instance
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        // create a copy of current node
        Node copy_Node = new Node(node.val);
        oldToNew.put(node, copy_Node);

        // recursively clone all the neighbors
        for(Node neighbor : node.neighbors) {
            copy_Node.neighbors.add(dfs(neighbor));
        }

        return copy_Node;
    }

}