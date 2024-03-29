// https://leetcode.com/problems/integer-break

class Solution {
    public int integerBreak(int n) {
        // dp 
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for(int i=2; i<=n; i++){
            
            for(int j=1; j<=i/2; j++){
                dp[i] = Math.max(dp[i], Math.max(j, dp[j])* Math.max(i-j, dp[i-j]));
            }
            
        }
        
        return dp[n];
    }
}