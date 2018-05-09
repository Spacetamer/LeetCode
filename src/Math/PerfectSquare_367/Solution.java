package Math.PerfectSquare_367;

class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 0;
        int square = 0;
        int lastSquare = square;
        while (square < num){
            square += (2 * i++ + 1);
            if (square < lastSquare) return false;
            lastSquare = square;
        }

        return square == num;
    }
}
