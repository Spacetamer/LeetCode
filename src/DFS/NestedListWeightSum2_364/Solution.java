package DFS.NestedListWeightSum2_364;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> ravel = new ArrayList<>();
        dfs(nestedList, ravel, 0);
        int weight = ravel.size();
        int sum = 0;
        for (int levelSum: ravel) {
            System.out.println(levelSum);
            sum += (weight--) * levelSum;
        }
        return sum;
    }

    private void dfs(List<NestedInteger> nestedList, List<Integer> ravel, int depth){
        for (NestedInteger nestedInteger: nestedList) {
            if (nestedInteger.isInteger()) {
                System.out.println("Level = "+depth+" Val = "+nestedInteger.getInteger());
                if (ravel.size() < depth+1)
                    ravel.add(depth, nestedInteger.getInteger());
                else ravel.set(depth, ravel.get(depth) + nestedInteger.getInteger());
            }
            else
                dfs(nestedInteger.getList(), ravel,depth+1);
        }
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}