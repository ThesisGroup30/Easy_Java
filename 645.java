class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int duplicate = -1, missing = -1;
        
        // Sort the array
        Arrays.sort(nums);
        
        // Check for duplicate and missing numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] == nums[(i + 1) % n]) {
                duplicate = nums[i];
            } else if (nums[i] != i + 1) {
                missing = i + 1;
            }
        }
        
        return new int[] {duplicate, missing};
    }
}
