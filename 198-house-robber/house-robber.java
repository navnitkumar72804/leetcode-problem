class Solution {
    private int[] memo;
    
    public int rob(int[] nums) {
        memo = new int[nums.length + 1];
        Arrays.fill(memo, -1);
        return dp(nums, nums.length - 1);
    }
    
    private int dp(int[] nums, int i) {
        if (i < 0) return 0;
        if (memo[i] != -1) return memo[i];
        
        // Either rob current house (nums[i] + best from i-2) or skip it (best from i-1)
        memo[i] = Math.max(dp(nums, i - 1), dp(nums, i - 2) + nums[i]);
        return memo[i];
    }
}