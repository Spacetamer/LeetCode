package Math.PoorPig_458;

class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int testBase = minutesToTest / minutesToDie + 1;

        int i = 0;
        while (Math.pow(testBase, i) < buckets) ++i;
        return i;
    }
}
