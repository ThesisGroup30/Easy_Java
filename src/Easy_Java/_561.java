package Easy_Java;

import java.util.Arrays;

public class _561 {
	public int arrayPairSum(int[] nums) {
	       // Sort the input array in ascending order
	        Arrays.sort(nums);
	        
	        int sum = 0;
	        // Iterate over the sorted array and add the min value from each pair to the sum
	        for (int i = 0; i < nums.length; i += 2) {
	            sum += nums[i];
	        }
	        
	        return sum; 
	    }
}
