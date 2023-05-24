class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length, m = queries.length;
        int[] ans = new int[m];
        Arrays.sort(nums); // sort the array to use binary search
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for (int i = 0; i < m; i++) {
            int q = queries[i];
            if (q < nums[0]) {
                ans[i] = 0; // no subsequence can be formed
            } else if (q >= prefixSum[n-1]) {
                ans[i] = n; // all elements can be taken
            } else {
                int lo = 0, hi = n-1;
                while (lo < hi) {
                    int mid = lo + (hi - lo + 1) / 2; // round up mid to avoid infinite loop
                    if (prefixSum[mid] > q) {
                        hi = mid - 1;
                    } else {
                        lo = mid;
                    }
                }
                ans[i] = lo + 1; // add 1 to include lo-th element
            }
        }
        return ans;
    }
}
