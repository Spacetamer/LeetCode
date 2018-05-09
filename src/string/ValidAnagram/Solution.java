package string.ValidAnagram;

class Solution {
    public boolean isAnagram(String s, String t) {

        int[] difference = new int[256];

        for (char c: s.toCharArray())
            ++difference[c];

        for (char c: t.toCharArray())
            --difference[c];

        for (int count: difference)
            if (count != 0) return false;
        return true;
    }
}
