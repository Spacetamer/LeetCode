package string.FirstUniqueCharacter;

class Solution {
    public int firstUniqChar(String s) {
        int[] count = new int[128];
        char[] string = s.toCharArray();

        for (char c: string)
            ++count[c];

        for (int i=0; i<string.length; ++i)
            if (count[string[i]] == 1)
                return i;
        return -1;
    }
}
