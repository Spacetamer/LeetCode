package DynamicProgramming.MinCostClimbingStairs_746;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int N = cost.length;
        for (int i=2; i<N; ++i){
            cost[i] += Math.min(cost[i-1], cost[i-2]);
        }
        return Math.min(cost[N-1], cost[N-2]);
    }
}
