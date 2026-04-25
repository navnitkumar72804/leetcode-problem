class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        
        for (int i = 1; i <= len; i++) {
            // Count zeros and ones in current string
            int[] count = countZerosOnes(strs[i - 1]);
            int zeros = count[0];
            int ones = count[1];
            
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // Option 1: Skip current string
                    dp[i][j][k] = dp[i - 1][j][k];
                    
                    // Option 2: Include current string if capacity allows
                    if (j >= zeros && k >= ones) {
                        dp[i][j][k] = Math.max(dp[i][j][k], 
                                                dp[i - 1][j - zeros][k - ones] + 1);
                    }
                }
            }
        }
        
        return dp[len][m][n];
    }
    
    private int[] countZerosOnes(String str) {
        int zeros = 0;
        for (char c : str.toCharArray()) {
            if (c == '0') zeros++;
        }
        return new int[]{zeros, str.length() - zeros};
    }
}