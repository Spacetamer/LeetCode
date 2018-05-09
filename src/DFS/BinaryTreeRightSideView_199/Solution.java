package DFS.BinaryTreeRightSideView_199;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new LinkedList<>();
        rightView(root, 0, view);
        return view;
    }

    private void rightView(TreeNode root, int depth, List<Integer> view){
        if (root == null) return;
        if (view.size() == depth) view.add(root.val);
        rightView(root.right, depth+1, view);
        rightView(root.left, depth+1, view);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
