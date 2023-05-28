package Easy_Java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2363 {
	public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        // Create a HashMap to store the sum of weights for each value
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate over items1 and update the weights in the HashMap
        for (int i = 0; i < items1.length; i++) {
            int value = items1[i][0];
            int weight = items1[i][1];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + weight);
            } else {
                map.put(value, weight);
            }
        }
        
        // Iterate over items2 and update the weights in the HashMap
        for (int i = 0; i < items2.length; i++) {
            int value = items2[i][0];
            int weight = items2[i][1];
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + weight);
            } else {
                map.put(value, weight);
            }
        }
        
        // Create a List of Lists to store the result
        List<List<Integer>> result = new ArrayList<>();
        
        // Iterate over the entries in the HashMap and add them to the result
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getKey();
            int weight = entry.getValue();
            List<Integer> item = new ArrayList<>();
            item.add(value);
            item.add(weight);
            result.add(item);
        }
        
        // Sort the result by value
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> item1, List<Integer> item2) {
                return item1.get(0) - item2.get(0);
            }
        });
        
        return result;
    }
}
