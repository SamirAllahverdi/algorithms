package hackerRank.recentImpls;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquilazeTheArray {





    public static int equalizeArray(List<Integer> arr) {


        Map<Integer, Integer> map = new HashMap<>();

        for (int el : arr) {
            map.put(el, map.getOrDefault(el, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }

        return arr.size() - max;
    }
}
