package binarySearch.ValidPerfectSquare;

public class Solution {
    public boolean isPerfectSquare(int num) {
        int product = 0;
        for (int i=0; product<=num; ++i){
            product = i*i;
            if (product == num) return true;
        }
        return false;
    }
}
