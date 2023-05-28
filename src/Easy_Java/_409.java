package Easy_Java;

import java.util.HashMap;
import java.util.Map;

public class _409 {
	public int longestPalindrome(String s) {
        // Create a hashmap to count the frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Iterate through the map to count the number of characters that can be used to form a palindrome
        int count = 0;
        boolean hasOdd = false;
        for (int freq : freqMap.values()) {
            if (freq % 2 == 0) {
                count += freq;
            } else {
                count += freq - 1;
                hasOdd = true;
            }
        }
        
        // If there was at least one character with odd frequency, add 1 to the count
        if (hasOdd) {
            count += 1;
        }
        
        return count;
    }
}
