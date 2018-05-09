package DynamicProgramming.UniqueBST;

public class Solution {
    public static int numTrees(int n) {
        if (n <= 1) return 1;
        int[] F = new int[n+1];
        F[0] = 1;
        F[1] = 1;
        for (int i=2; i<=n; ++i){
            for (int j=0; j<i/2; ++j)
                F[i] += F[j] * F[i-1-j];
            F[i] *= 2;
            if (i % 2 == 1)
                F[i] += F[i/2]*F[i/2];
        }
        return F[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(10));
    }
}
