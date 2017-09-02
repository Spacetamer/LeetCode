package DFS.SortedArray2BST;

import java.util.Arrays;

public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        int N = nums.length;
        if (N == 0) return null;
        if (N == 1) return new TreeNode(nums[0]);
        int mid = N/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, 0, mid);
        root.right = sortedArrayToBST(nums, mid+1, N);
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int N = end - start;
        if (N == 0) return null;
        if (N == 1) return new TreeNode(nums[start]);
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid+1, end);
        return root;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        for (int i: Arrays.copyOfRange(array,1,4))
            System.out.println(i);
    }
}
