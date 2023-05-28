package Easy_Java;

import java.util.HashMap;
import java.util.Map;

public class _914 {
	public boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length < 2) {
            return false;
        }
        
        // Count the frequency of each number in the deck
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : deck) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        // Get the minimum frequency of any number
        int minFreq = Integer.MAX_VALUE;
        for (int f : freq.values()) {
            minFreq = Math.min(minFreq, f);
        }
        
        // Find the greatest common divisor of all frequencies
        for (int x = 2; x <= minFreq; x++) {
            boolean isDivisor = true;
            for (int f : freq.values()) {
                if (f % x != 0) {
                    isDivisor = false;
                    break;
                }
            }
            if (isDivisor) {
                return true;
            }
        }
        
        return false;
    }
}
