package BackTrack.CountNumbersWithUniqueDigits_357;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n==1) return 10;
        if (n>10) return countNumbersWithUniqueDigits(10);
        if (n<=0) return 1;
        int thisLevel = 9, count=n, rest=9;
        while (count>1) {
            thisLevel *= rest--;
            --count;
        }
        return thisLevel + countNumbersWithUniqueDigits(--n);
    }
}
