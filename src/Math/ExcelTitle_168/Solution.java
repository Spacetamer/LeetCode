package Math.ExcelTitle_168;

class Solution {
    public String convertToTitle(int n) {
        String results = "";
        while (n != 0) {
            --n;
            results = ((char)('A' + n%26)) + results;
            n /= 26;
        }

        return results;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(26));
    }
}