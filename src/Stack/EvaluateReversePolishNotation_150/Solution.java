package Stack.EvaluateReversePolishNotation_150;

class Solution {
    public int evalRPN(String[] tokens) {
        int p1 = Integer.parseInt(tokens[0]);
        int p2 = Integer.parseInt(tokens[1]);

        for (int i=3; i<tokens.length; ++i) {
            String op = tokens[i];
            if ("+".equals(op))
                p1 += p2;
            else if ("-".equals(op))
                p1 -= p2;
            else if ("*".equals(op))
                p1 *= p2;
            else if ("/".equals(op))
                p1 /= p2;
            else p2 = Integer.parseInt(op);
        }

        return p1;
    }
}
