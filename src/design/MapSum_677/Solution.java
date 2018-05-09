package design.MapSum_677;

import java.util.HashMap;

class MapSum {

    /** Initialize your data structure here. */
    private HashMap<String, Integer> repsitory;

    public MapSum() {
        repsitory = new HashMap<>();
    }

    public void insert(String key, int val) {
        repsitory.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        for (String key: repsitory.keySet()){
            if (key.startsWith(prefix))
                sum += repsitory.get(key);
        }
        return sum;
    }
}
