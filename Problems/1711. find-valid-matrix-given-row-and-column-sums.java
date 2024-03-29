// https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] res = new int[rowSum.length][colSum.length];
        
        // Arrays.sort(rowSum);
        // Arrays.sort(cilSum);
        
        for(int i=0; i<rowSum.length; i++){
            for(int j=0; j<colSum.length; j++){
                
                
                res[i][j] = Math.min(rowSum[i], colSum[j]);
                
                rowSum[i] -= res[i][j];
                colSum[j] -= res[i][j];
                
            }
        }
        
        
        return res;
    }
    
//     private void helper(int[] rowSum, int[] colSum, int[][] res){
//     }
}