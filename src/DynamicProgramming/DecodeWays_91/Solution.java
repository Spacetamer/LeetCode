package DynamicProgramming.DecodeWays_91;

class Solution {
    public int numDecodings(String s) {
        char[] stream = s.toCharArray();
        int N = stream.length;
        if (N<1) return 0;
        int[] ways = new int[N];
        int i=0;
        for (char c: stream)
            if (c>'0' && c<='9') ++ways[i++];
        if (N==1) return ways[0];
        int first2 = stream[0]-'0' + (stream[1]-'0')*10;
        if (first2>=10 && first2<=26) ++ways[1];
        System.out.println(first2);
        for (i=2; i<N; ++i){
            ways[i] = ways[i] > 0 ? ways[i-1] : 0;
            int last2 = stream[i]-'0' + (stream[i-1]-'0')*10;
            if (last2>=10 && last2<=26)
                ways[i] += ways[i-2];
        }
        return ways[N-1];
    }
}
