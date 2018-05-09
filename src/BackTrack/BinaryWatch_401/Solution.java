package BackTrack.BinaryWatch_401;

import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] h_sig = new int[]{0,1,2,3};
        int[] m_sig = new int[]{0,1,2,3,4,5};
        List<String> result = new LinkedList<>();

        for (int i=0; i<=num; ++i){
            List<Integer> hours = generateNumber(h_sig, i, 12);
            List<Integer> minutes = generateNumber(m_sig, num-i, 60);
            for (int hour: hours){
                for (int minute: minutes)
                    result.add(hour+":"+ (minute<10?"0"+minute:minute) );
            }
        }

        return result;
    }

    private List<Integer> generateNumber(int[] sig, int bits, int limit){
        List<Integer> result = new LinkedList<>();
        generateHelper(sig, result, bits, 0, 0, limit);
        return result;
    }

    private void generateHelper(int[] sig, List<Integer> result, int count, int current, int bit, int limit){
        if (count == 0) {
            if (current < limit)
                result.add(current);
            return;
        }

        for (int i=bit; i<sig.length; ++i){
            generateHelper(sig, result, count-1, current+(1<<sig[i]), i+1, limit);
        }
    }
}