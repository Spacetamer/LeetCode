package Math.CountPrime_204;


class Solution {
    public int countPrimes(int n) {
        if (n<3) return 0;
        boolean[] isComposite = new boolean[n];
        int count = n / 2;

        for (int i = 3; i * i < n; i += 2){
            if (isComposite[i]) continue;
            for (int j = i*i; j<n; j += 2*i){
                if (!isComposite[j]){
                    --count;
                    isComposite[j] = true;
                }
            }
        }

        return count;
    }
}
