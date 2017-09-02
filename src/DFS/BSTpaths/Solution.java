package DFS.BSTpaths;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> results = new LinkedList<>();
        if (root == null) return results;
        if (root.left == null && root.right == null){
            results.add(""+root.val);
        }

        for (String path: binaryTreePaths(root.left))
            results.add(root.val+"->"+path);
        for (String path: binaryTreePaths(root.right))
            results.add(root.val+"->"+path);
        return results;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

