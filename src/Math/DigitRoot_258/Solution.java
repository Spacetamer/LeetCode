package Math.DigitRoot_258;

class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        int reisdual = num % 9;
        if (reisdual == 0) return 9;
        return reisdual;
    }
}
