// https://leetcode.com/problems/house-robber-ii

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        
        
        if(len==1) 
            return nums[0];
        
        // house 1 to n-1;
        for(int i=1; i<len; i++){
            dp[i] = Math.max(dp[i-1], (i<2? 0: dp[i-2]) + nums[i-1]);
        }
        int max = dp[len-1];
        
        System.out.println(max);
        
        // dp = new int[len+1];
        dp[1] = 0;
        
        // house 2 to n;
        for(int i=2; i<=len; i++){
            dp[i] = Math.max(dp[i-1], (i<2? 0: dp[i-2]) + nums[i-1]);
        }
        max = Math.max(max, dp[len]);
        
        return max;
    }
}