// https://leetcode.com/problems/maximal-square

class Solution {
    
    int maxLen=1;
    
    public int maximalSquare(char[][] matrix) {

        int h=matrix.length;
        int w=matrix[0].length;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                
                for(int k=1; k+i<h&&k+j<w; k++){
                    if(isValid(matrix, i, j, k));
                       maxLen = Math.max(maxLen, k+1);
                }
                
            }
        }
        return maxLen;
        
    }
    
                       
    private boolean isValid(char[][] matrix, int i, int j, int k){
        
        for(int r=i; r<i+k; r++){
            for(int c=j; c<j+k; c++){
                
                if(matrix[r][c]=='0')
                    return false;
            }
        }
        
        return true;
    }               
                       
    
//     private boolean dfs(char[][] matrix, int i, int j){
        
//         if(i==matrix.length) return true;
//         if(j==matrix[0].length) return dfs(matrix, i+1, 0);
//     }
}