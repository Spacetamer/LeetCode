package DFS.PopulatingNextRightPointersInEachNode_116;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> record = new ArrayList<>();
        connectToRight(root, 1, record);
    }

    private void connectToRight(TreeLinkNode root, int depth, List<TreeLinkNode> record){
        if (root == null) return;
        if (record.size() < depth) {
            record.add(root);
            root.next = null;
        } else {
            root.next = record.get(depth - 1);
            record.set(depth - 1, root);
        }
        connectToRight(root.right, depth+1, record);
        connectToRight(root.left, depth+1, record);
    }

    public class TreeLinkNode {
       int val;
       TreeLinkNode left, right, next;
       TreeLinkNode(int x) { val = x; }
   }
}
