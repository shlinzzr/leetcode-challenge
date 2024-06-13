// https://leetcode.com/problems/maximum-sum-of-subsequence-with-non-adjacent-elements

class Solution {
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int len = nums.length;
        
        int sum = 0 ;
        for(int[] q : queries){
            
            int pos = q[0];
            int x = q[1];
            nums[pos] = x;
            
            int[][] dp = new int[len+1][2];
        
            // dp[1][1] = Math.max(0, nums[0]);
            // dp[2][0] = dp[1][1];
            // dp[2][1] = Math.max(0, nums[1]);
            for(int i=1; i<=len; i++){
                dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
                dp[i][1] = dp[i-1][0] + nums[i-1];
            }    
            
            sum += Math.max(dp[len][0], dp[len][1]);            
            // System.out.println(sum);
            
        }
        
        return sum;
        
        
    }
}