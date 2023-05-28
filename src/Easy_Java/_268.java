package Easy_Java;

public class _268 {
	public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2; // calculate the sum of the range [0, n]
        for (int i = 0; i < n; i++) {
            sum -= nums[i]; // subtract the sum of the given array
        }
        return sum;
    }
}
