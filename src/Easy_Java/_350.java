package Easy_Java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _350 {
	public int[] intersect(int[] nums1, int[] nums2) {
        // Create hash maps to keep track of the count of each number in each array
        Map<Integer, Integer> counts1 = new HashMap<>();
        Map<Integer, Integer> counts2 = new HashMap<>();
        
        // Populate the hash maps with counts
        for (int num : nums1) {
            counts1.put(num, counts1.getOrDefault(num, 0) + 1);
        }
        for (int num : nums2) {
            counts2.put(num, counts2.getOrDefault(num, 0) + 1);
        }
        
        // Create a list to hold the intersection
        List<Integer> intersection = new ArrayList<>();
        
        // Loop through the keys in the first hash map
        for (int num : counts1.keySet()) {
            // If the second hash map contains the same key, add the minimum count to the intersection list
            if (counts2.containsKey(num)) {
                int count = Math.min(counts1.get(num), counts2.get(num));
                for (int i = 0; i < count; i++) {
                    intersection.add(num);
                }
            }
        }
        
        // Convert the intersection list to an array
        int[] result = new int[intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            result[i] = intersection.get(i);
        }
        
        return result;
    }
}
