package array.PascalTriangle2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> getRow(int rowIndex) {
        int[] result = new int[rowIndex+1];
        result[0] = 1;
        result[rowIndex] = 1;

        int left = 1, right = rowIndex - 1;
        int lastValue = 1;

        while (left < rowIndex/2 + 1){
            double ratio = (rowIndex - left + 1.0) / left;
            double value = lastValue * ratio;

            lastValue = (int)Math.round(value);
            result[left] = lastValue;
            result[right] = lastValue;
            ++left;
            --right;
        }

        ArrayList<Integer> results = new ArrayList<>();
        for (int a: result) {
            results.add(a);
        }
        return results;
    }

    public static void main(String[] args) {
        System.out.println(getRow(0));
    }
}
