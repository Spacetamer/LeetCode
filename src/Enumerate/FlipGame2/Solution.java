package Enumerate.FlipGame2;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public boolean canWin(String s) {
        List<String> results = new LinkedList<>();
        char[] chess = s.toCharArray();

        for (int i = 1; i < chess.length; ++i){
            if (chess[i] == '+' && chess[i-1] == '+'){
                inverse(chess, i);
                results.add(new String(chess));
                inverse(chess, i);
            }
        }

        for (String result: results)
            if (!canWin(result))
                return true;

        return false;
    }

    private void inverse(char[] chess, int index){
        char point = chess[index] =='+' ? '-' : '+';
        chess[index] = point;
        chess[index-1] = point;
    }
}
