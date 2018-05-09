package BackTrack.PalindromePermutation2_267;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[128];
        int odd = 0;
        for (char c: s.toCharArray())
            ++count[c];
        List<String> res = new LinkedList<>();
        for (int f: count)
            odd += f%2;
        if (odd <= 1)
            backTrack(s.toCharArray(), count, 0, s.length()-1, res);
        return res;
    }

    private void backTrack(char[] str, int[] count, int left, int right, List<String> res){
        if (left > right){
            res.add(String.valueOf(str));
            return;
        }

        char c = 0;
        if (left != right){
            for (int f: count) {
                if (f>1) {
                    str[left] = c;
                    str[right] = c;
                    count[c] -= 2;
                    backTrack(str, count, left+1, right-1, res);
                    count[c] += 2;
                }
                ++c;
            }
        } else {
            for (int f: count) {
                if (f!=0){
                    str[left] = c;
                    res.add(String.valueOf(str));
                    return;
                }
                ++c;
            }
        }
    }
}
