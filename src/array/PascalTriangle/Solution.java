package array.PascalTriangle;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> results = new LinkedList<>();
        for (int i=0; i!= numRows; ++i)
            results.add(getRow(i));
        return results;
    }

    private static List<Integer> getRow(int rowIndex) {
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

        LinkedList<Integer> results = new LinkedList<>();
        for (int a: result) {
            results.add(a);
        }
        return results;
    }
}