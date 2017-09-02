package TwoPointers.ReverseVowel;

import java.util.HashSet;

class Solution {
    public String reverseVowels(String s) {
        if (s.length()==0) return "";
        char[] res= s.toCharArray();
        int st=0, end = res.length-1;
        boolean[] isv= new boolean[256];
        isv['a'] = true;
        isv['e'] = true;
        isv['i'] = true;
        isv['o'] = true;
        isv['u'] = true;
        isv['A'] = true;
        isv['E'] = true;
        isv['I'] = true;
        isv['O'] = true;
        isv['U'] = true;
        while (true){
            while(st<end && !isv[res[st]]) ++st;
            while(st<end && !isv[res[end]]) --end;
            if (st>=end) break;
            char temp = res[st];
            res[st]= res[end];
            res[end]= temp;
            ++st; --end;
        }
        return new String(res);
    }
}
