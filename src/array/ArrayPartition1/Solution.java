package array.ArrayPartition1;

public class Solution {
    public static int arrayPairSum(int[] nums) {
        int[] hashtable = new int[20001];
        int N =nums.length;
        for(int i=0;i!=N;++i)
            ++hashtable[nums[i]+10000];

        int ret=0;
        int flag=0;
        for(int i=0;i!=20001;){
            if((hashtable[i]>0)&&(flag==0)){
                ret=ret+i-10000;
                flag=1;
                --hashtable[i];
            }else if((hashtable[i]>0)&&(flag==1)){
                --hashtable[i];
                flag=0;
            }else
                ++i;
        }
        return ret;
    }

    private static void quickSort(int[] numbers, int start, int end) {
        if (start < end) {
            int base = numbers[start]; // 选定的基准值（第一个数值作为基准值）
            int temp; // 记录临时中间值
            int i = start, j = end;
            do {
                while ((numbers[i] < base) && (i < end))
                    ++i;
                while ((numbers[j] > base) && (j > start))
                    --j;
                if (i <= j) {
                    temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                    ++i;
                    --j;
                }
            } while (i <= j);
            if (start < j)
                quickSort(numbers, start, j);
            if (end > i)
                quickSort(numbers, i, end);
        }
    }

    public static void main(String[] args) {
        int[] A = {1,4,3,2};
        quickSort(A, 0, A.length-1);
        for (int a: A){
            System.out.println(a);
        }
    }
}
