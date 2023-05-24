import java.util.*;

class Solution {
    public int splitNum(int num) {
        // Convert num to a string and count the occurrences of each digit
        Map<Character, Integer> digitCounts = new HashMap<>();
        for (char c : Integer.toString(num).toCharArray()) {
            digitCounts.put(c, digitCounts.getOrDefault(c, 0) + 1);
        }
        
        // Try all possible pairs of digit counts that sum to the total count
        int totalDigits = Integer.toString(num).length();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i <= totalDigits; i++) {
            int j = totalDigits - i;
            if (i > digitCounts.size() || j > digitCounts.size()) {
                continue;
            }
            int sum = getSumForSplit(digitCounts, i, j);
            if (sum < minSum) {
                minSum = sum;
            }
        }
        
        return minSum;
    }
    
    // Returns the sum of num1 and num2 if num can be split into num1 and num2 such that
    // the counts of the digits in num1 and num2 are i and j, respectively
    private int getSumForSplit(Map<Character, Integer> digitCounts, int i, int j) {
        Map<Character, Integer> countsCopy = new HashMap<>(digitCounts);
        int sum = 0;
        StringBuilder num1Builder = new StringBuilder();
        StringBuilder num2Builder = new StringBuilder();
        
        // Construct num1
        for (char c = '0'; c <= '9'; c++) {
            if (!countsCopy.containsKey(c)) {
                continue;
            }
            int count = countsCopy.get(c);
            if (i >= count) {
                num1Builder.append(String.valueOf(c).repeat(count));
                i -= count;
                countsCopy.remove(c);
            } else {
                num1Builder.append(String.valueOf(c).repeat(i));
                countsCopy.put(c, count - i);
                break;
            }
        }
        
        // Construct num2
        for (char c = '0'; c <= '9'; c++) {
            if (!countsCopy.containsKey(c)) {
                continue;
            }
            int count = countsCopy.get(c);
            if (j >= count) {
                num2Builder.append(String.valueOf(c).repeat(count));
                j -= count;
                countsCopy.remove(c);
            } else {
                num2Builder.append(String.valueOf(c).repeat(j));
                countsCopy.put(c, count - j);
                break;
            }
        }
        
        sum = Integer.parseInt(num1Builder.toString()) + Integer.parseInt(num2Builder.toString());
        return sum;
    }
}
