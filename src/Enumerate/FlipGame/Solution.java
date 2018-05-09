package Enumerate.FlipGame;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new LinkedList<>();
        char[] chess = s.toCharArray();

        for (int i = 1; i < chess.length; ++i){
            if (chess[i] == '+' && chess[i-1] == '+'){
                inverse(chess, i);
                results.add(new String(chess));
                inverse(chess, i);
            }
        }

        return results;
    }

    private void inverse(char[] chess, int index){
        char point = chess[index] =='+' ? '-' : '+';
        chess[index] = point;
        chess[index-1] = point;
    }
}
