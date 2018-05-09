package DFS.BSTMaxPathSum_124;

public class Solution {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root != null) maxSinglePathSum(root);
        return maxSum;
    }

    private int maxSinglePathSum(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(maxSinglePathSum(root.left), 0);
        int right = Math.max(maxSinglePathSum(root.right), 0);
        maxSum = Math.max(maxSum, left+right+root.val);
        return root.val + Math.max(left, right);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
