package DFS.FindLargestValueInEachTreeRow_515;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List levelMax = new ArrayList();
        dfs(root, 0, levelMax);
        return levelMax;
    }

    private void dfs (TreeNode root, int level, List<Integer> levelMax){
        if (root == null) return;
        if (levelMax.size() != level){
            int curr = levelMax.get(level);
            if (curr < root.val)
                levelMax.set(level, root.val);
        } else  {
            levelMax.add(level, root.val);
        }
        dfs(root.left, level+1, levelMax);
        dfs(root.right, ++level, levelMax);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
