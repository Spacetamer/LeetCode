package array.AddBinary;

class Solution {
    public String addBinary(String a, String b) {
        int m = a.length() - 1;
        int n = b.length() - 1;

        if (m < n) return addBinary(b, a);

        char[] n1 = a.toCharArray();
        char[] n2 = b.toCharArray();
        int carry = 0;
        char[] results = new char[m+1];
        while (m >= 0) {
            int sum = carry;
            sum += (n1[m] - '0');
            if (n >= 0) sum += (n2[n--] - '0');

            results[m--] = (char) (sum % 2 + '0');
            carry = sum / 2;
        }
        String result = new String(results);
        if (carry != 0) result = '1' + result;
        return result;
    }
}
