package binarySearch.FirstBadVersion_278;

public class Solution {
    public int firstBadVersion(int n) {
        if (isBadVersion(1)) return 1;
        int curr = n - (n - 1) / 2;
        int left = 1, right = n;
        while (left != right - 1){
            if (isBadVersion(curr)) right = curr;
            else left = curr;
            curr = right - (right - left) / 2;
        }

        return right;
    }

    private boolean isBadVersion(int version){
        return version >= 13;
    };

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(3412));
    }
}
