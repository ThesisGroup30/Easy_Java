package Easy_Java;

public class _1979 {
	public int findGCD(int[] nums) {
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;
        
        // Find the smallest and largest numbers in the array
        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        
        // Calculate the greatest common divisor of the smallest and largest numbers
        return findGCDHelper(minNum, maxNum);
    }
    
    // Helper method to calculate the greatest common divisor of two numbers using Euclid's algorithm
    private int findGCDHelper(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return findGCDHelper(b, a % b);
        }
    }
}
