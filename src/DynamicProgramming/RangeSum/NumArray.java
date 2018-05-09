package DynamicProgramming.RangeSum;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class NumArray {

    public NumArray(int[] nums) {
        int N = nums.length;
        accumulateSum = new int[N+1];
        int previous = 0;
        for (int i=1; i<=N; ++i){
            previous += nums[i-1];
            accumulateSum[i] = previous;
        }
    }

    public int sumRange(int i, int j) {
        return this.accumulateSum[++j] - this.accumulateSum[i];
    }

    private int[] accumulateSum;

    public static void main(String args[]) throws Exception {
        try {
            URL url = new URL("http://www.baidu.com");
            InputStream in =url.openStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader bufr = new BufferedReader(isr);
            String str;
            while ((str = bufr.readLine()) != null) {
                System.out.println(str);
            }
            bufr.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
