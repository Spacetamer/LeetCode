package string.Isomorphic_205;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] table = new char[256];
        char[] reverseTable = new char[256];

        char[] first = s.toCharArray();
        char[] second = t.toCharArray();

        for (int i=0; i != first.length; ++i){
            char a = first[i];
            char b = second[i];
            if (table[a] == 0) {
                if (reverseTable[b] != 0) return false;
                table[a] = b;
                reverseTable[b] = a;
            }
            else if (table[a] != b || reverseTable[b] != a) return false;
        }

        return true;
    }
}
