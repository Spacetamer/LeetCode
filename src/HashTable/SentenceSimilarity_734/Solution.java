package HashTable.SentenceSimilarity_734;

import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean areSentencesSimilar(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) return false;
        HashMap<String, HashSet<String>> dict = new HashMap<>();
        for (String[] pair: pairs){
            HashSet<String> sim0 = dict.get(pair[0]);
            HashSet<String> sim1 = dict.get(pair[1]);
            if (sim0 == null){
                sim0 = new HashSet<>();
                dict.put(pair[0], sim0);
            }

            if (sim1 == null){
                sim1 = new HashSet<>();
                dict.put(pair[1], sim1);
            }
            sim0.add(pair[1]);
            sim1.add(pair[0]);
        }

        int i=0;
        for (String word1: words1){
            if (!word1.equals(words2[i]) && (dict.get(word1)==null || !dict.get(word1).contains(words2[i]))){
                System.out.println("1:"+word1+" 2:"+words2[i]+" correct:"+dict.get(word1));
                return false;}
            ++i;
        }
        return true;
    }
}