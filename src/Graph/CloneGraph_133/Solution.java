package Graph.CloneGraph_133;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    private HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node.label)) return map.get(node.label);
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);
        HashMap<Integer, Integer> map = null;
        for (UndirectedGraphNode neighbor: node.neighbors)
            root.neighbors.add(cloneGraph(neighbor));
        return root;
    }

    class UndirectedGraphNode {
       int label;
       List<UndirectedGraphNode> neighbors;
       UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
   }
}
