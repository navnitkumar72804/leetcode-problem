class Solution {
    private int[] memo;
    
    public int minCostClimbingStairs(int[] cost) {
        memo = new int[cost.length + 1];
        Arrays.fill(memo, -1);
        return Math.min(dp(cost, 0), dp(cost, 1));
    }
    
    private int dp(int[] cost, int i) {
        if (i >= cost.length) return 0; // Reached the top
        if (memo[i] != -1) return memo[i];
        
        // Pay current cost, then take 1 or 2 steps
        memo[i] = cost[i] + Math.min(dp(cost, i + 1), dp(cost, i + 2));
        return memo[i];
    }
}