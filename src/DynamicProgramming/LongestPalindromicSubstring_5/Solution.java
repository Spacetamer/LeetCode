package DynamicProgramming.LongestPalindromicSubstring_5;

class Solution {
    public String longestPalindrome(String s) {
        char[] c = s.toCharArray();
        int N = c.length;

        boolean[][] valid = new boolean[N][N];
        for(int i=0; i<N-1; ++i){
            valid[i][i] = true;
            valid[i][i+1] = (c[i]==c[i+1]);
        }
        valid[N-1][N-1] = true;

        for(int i=N-1; i>=0; --i){
            for(int j=i+2; j<N; ++j){
                valid[i][j] = valid[i+1][j-1] && (c[i]==c[j]);
            }
        }

        int len = 1; String res=s.substring(0,1);
        for(int i=0; i!=N; ++i){
            for(int j=i+1; j<N; ++j){
                if (valid[i][j] && (j-i+1)>len){
                    len = j-i+1;
                    res = s.substring(i,j+1);
                }
            }
        }
        System.out.println(len);
        return res;
    }

    public static void main(String[] args) {
        String s = "babab";
        String r = new Solution().longestPalindrome(s);
    }
}
