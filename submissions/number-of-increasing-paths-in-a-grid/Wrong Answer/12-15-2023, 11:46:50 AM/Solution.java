// https://leetcode.com/problems/number-of-increasing-paths-in-a-grid

class Solution {
    int M = (int) 1e9+7;
    int res = 0;
    public int countPaths(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        
        int[][] memo = new int[h][w];
        for(int[] m : memo){
            Arrays.fill(m, 1);
        }
        int max =1;
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(memo[i][j]==1){
                    int rt = dfs(grid, i, j, memo);
                    max = Math.max(max, rt);

                    
                }
                res = (res + memo[i][j])%M;
            }
        }

        

        return res;
    }

    int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int dfs(int[][] grid, int i, int j, int[][] memo){

        int h = grid.length;
        int w = grid[0].length;

        if(memo[i][j]!=1){
            return memo[i][j];
        }   


        int max = 1;
        for(int[] d: dirs){
            int r = d[0]+i;
            int c = d[1]+j;

            if(r>=0 && c>=0 && r<h && c<w && grid[i][j]<grid[r][c]){
                int rt = (int) ((1L + dfs(grid, r, c, memo))%M);
                max = Math.max(max, rt);
            }
        }
        memo[i][j] = max;
        return max;



    }
}