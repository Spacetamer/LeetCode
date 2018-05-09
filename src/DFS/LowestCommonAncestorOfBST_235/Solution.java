package DFS.LowestCommonAncestorOfBST_235;

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if ((root.val - p.val)*(root.val - q.val) <= 0) return root;
            if (root.val < p.val) root = root.right;
            else root = root.left;
        }

        return null;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
