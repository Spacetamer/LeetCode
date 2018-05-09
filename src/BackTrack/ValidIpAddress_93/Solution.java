package BackTrack.ValidIpAddress_93;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new LinkedList<>();
        backTrack(res, 3, "", 0, s.toCharArray());
        return res;

    }

    private void backTrack(List<String> res, int segCount, String current, int index, char[] string){
        if (index == string.length) return;

        int restLength = Math.min(4, string.length - index);
        if (segCount == 0) {
            if (string[index] == '0' && restLength != 1) return;
            String segment = new String(string, index, restLength);
            if (Integer.parseInt(segment) <= 255)
                res.add(current+segment);
            return;
        }
        if (string[index] == '0'){
            backTrack(res, segCount-1, current+"0.", index+1, string);
            return;
        }
        for (int i=1; i<=restLength; ++i){
            String segment = new String(string, index, i);
            if (Integer.parseInt(segment) <= 255) {
                backTrack(res, segCount-1, current+segment+'.', index+i, string);
            } else break;
        }
    }

    public static void main(String[] args) {
        for (String ip: new Solution().restoreIpAddresses("010010"))
            System.out.println(ip);
    }
}
