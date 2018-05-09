package Stack.BaseballGame_682;

class Solution {
    public int calPoints(String[] ops) {
        int[] score = new int[ops.length];
        int cursor = 0;
        for (String op: ops) {
            if ("C".equals(op))
                score[--cursor] = 0;
            else if ("D".equals(op)){
                score[cursor] = 2 * score[cursor-1];
                ++cursor;
            }
            else if ("+".equals(op)) {
                score[cursor] = score[cursor - 1] + score[cursor - 2];
                ++cursor;
            }
            else
                score[cursor++] = Integer.parseInt(op);
        }

        int f = 0;
        for (int s: score)
            f += s;
        return f;
    }
}
