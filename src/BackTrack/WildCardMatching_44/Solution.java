package BackTrack.WildCardMatching_44;

class Solution {
    private int s_len;
    private int p_len;

    public boolean isMatch(String s, String p) {
        s_len = s.length();
        p_len = p.length();
        return backTrack(s.toCharArray(), p.toCharArray(), 0, 0);
    }

    private boolean backTrack(char[] s, char[] p, int s_pos, int p_pos) {
        if (s_pos == s_len && p_pos == p_len) return true;
        if (s_pos == s_len) {
            while (p_pos < p_len)
                if (p[p_pos++] != '*') return false;
            return true;
        }
        if (p_pos == p_len) return false;

        if (s[s_pos] == p[p_pos] || p[p_pos] == '?')
            return backTrack(s, p, s_pos+1, p_pos+1);
        if (p[p_pos] != '*') return false;

        while (p_pos < p_len) {
            if (p[p_pos] != '*'){
                if (p[p_pos] == '?') ++s_pos;
                else break;
            }
            ++p_pos;
        }
        --p_pos;
        for (int cov=0; cov <= s_len-s_pos; ++cov)
            if (backTrack(s, p, s_pos+cov, p_pos+1))
                return true;
        return false;
    }

    public static void main(String[] args) {
        String a = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbb" +
                "bbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaa" +
                "bbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb";
        String b = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";
        System.out.println(new Solution().isMatch(a, b));
    }
}
