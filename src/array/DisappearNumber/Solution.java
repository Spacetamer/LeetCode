package array.DisappearNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int N = nums.length;

        int[] exist = new int[N+1];
        for (int num: nums)
            exist[num] = 1;

        ArrayList<Integer> result = new ArrayList<>();
        for (int i=1; i<=N; ++i){
            if (exist[i] != 1)
                result.add(i);
        }

        return result;
    }
}
