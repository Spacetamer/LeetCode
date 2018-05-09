package design.BSTiterator;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    private Stack<TreeNode> cache;
    public BSTIterator(TreeNode root) {
        cache = new Stack<>();
        TreeNode current = root;
        while (current != null){
            cache.push(current);
            current = current.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !cache.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = cache.pop();
        TreeNode current = node;
        if (current.right != null) {
            current = current.right;
            cache.push(current);
            while (current.left != null) {
                cache.push(current.left);
                current = current.left;
            }
        }

        return node.val;
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
