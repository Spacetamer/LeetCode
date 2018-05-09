package BackTrack.BeautifulArrangement_526;

class Solution {
    private int N;
    private int sol;
    public int countArrangement(int N) {
        this.N = N;
        sol = 0;
        backTrack(new boolean[N], 0);
        return sol;
    }

    private void backTrack(boolean[] use, int index){
        if (index == N){
            ++sol;
            return;
        }

        for (int i=(index+1)/2; i>1; --i){
            if ((index+1)%i==0 && !use[i-1]){
                use[i-1] = true;
                backTrack(use, index+1);
                use[i-1] = false;
            }
        }

        for (int mult=index+1; mult<=N; mult+=(index+1)){
            if (!use[mult-1]){
                use[mult-1] = true;
                backTrack(use, index+1);
                use[mult-1] = false;
            }
        }
    }
}