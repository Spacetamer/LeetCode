package design.BSTserializer;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        Deque<TreeNode> BFS = new ArrayDeque<>();
        List<String> treeNodes = new LinkedList<>();

        BFS.add(root);
        while (!BFS.isEmpty()){
            TreeNode current = BFS.poll();
            treeNodes.add(""+current.val);
        }

        return String.join(",", treeNodes);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return new TreeNode(0);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}