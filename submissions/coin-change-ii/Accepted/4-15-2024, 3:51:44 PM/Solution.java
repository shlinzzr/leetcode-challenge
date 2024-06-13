// https://leetcode.com/problems/coin-change-ii

class Solution {
    public int change(int amount, int[] coins) {

        int len = coins.length;
        int[][] dp = new int[len+1][amount+1];

        for(int i=1; i<=len; i++){
            dp[i][0] = 1; 

            for(int j=1; j<=amount; j++){

                dp[i][j] = dp[i-1][j];
                if(j-coins[i-1]>=0){
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[len][amount];




        
    }
}