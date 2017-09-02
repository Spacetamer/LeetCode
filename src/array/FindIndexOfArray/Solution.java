package array.FindIndexOfArray;

import java.util.HashMap;

public class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> index = new HashMap<>();
        int N = numbers.length;

        for (int i = 0; i!=N; ++i){
            int adder = numbers[i];
            index.put(adder, i);
            if (adder <= Math.floorDiv(target, 2))
                continue;
            try {
                int location = index.get(target - adder);
                return new int[]{location+1, i+1};
            }
            catch (NullPointerException e){
                continue;
            }

        }

        return null;
    }

    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return new int[2];
        }
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] > target) {
                // move end forward to the last value that numbers[end] <= target - numbers[start]
                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
            } else {
                // move start backword to the first value that numbers[start] >= target - numbers[end]
                start = smallestLargerOrFirstEqual(numbers, start, end, target - numbers[end]);
            }
        }
        return new int[2];
    }
    private static int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    private static int smallestLargerOrFirstEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] num = new int[]{-1,0,0,2,3,4,7,9,11,13,24,35,45,47,49,51};
        int target = 17;
        int MAX_ITER = 10000 * 10000;

        long s2 = System.currentTimeMillis();
        for (int i=0; i!=MAX_ITER; ++i)
            twoSum2(new int[]{-1, 0}, -1);
        long e2 = System.currentTimeMillis();
        System.out.println("Method 2:"+(e2 - s2));

        long s1 = System.currentTimeMillis();
        for (int i=0; i!=MAX_ITER; ++i)
            twoSum(new int[]{-1, 0}, -1);
        long e1 = System.currentTimeMillis();
        System.out.println("Method 1:"+(e1 - s1));
    }
}
