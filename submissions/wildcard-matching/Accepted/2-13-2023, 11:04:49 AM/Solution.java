// https://leetcode.com/problems/wildcard-matching

class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        
        // dp[i][j] => the pattern [0:j] can cover the string [0:i]
        
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0]=true;
        
        for(int j=0; j<n; j++){
            if(p.charAt(j)!='*')  break;
                dp[0][j+1]=true;
        }
        
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                
                if(p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];
                    
                }else if(p.charAt(j-1)=='*'){
                    
                    for(int k=0; k<=i; k++){
                        if(dp[k][j-1]==true) dp[i][j]=true;
                    }
                    
                }else if(s.charAt(i-1)==p.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                
                
            }
        }
        
        return dp[m][n];
    }
}
