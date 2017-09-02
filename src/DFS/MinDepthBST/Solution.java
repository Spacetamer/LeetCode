package DFS.MinDepthBST;

class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        boolean leftIsNull = root.left == null;
        boolean rightIsNull = root.right == null;
        if (!leftIsNull && !rightIsNull)
            return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        else if (leftIsNull)
            return 1 + minDepth(root.right);
        return 1 + minDepth(root.left);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}

