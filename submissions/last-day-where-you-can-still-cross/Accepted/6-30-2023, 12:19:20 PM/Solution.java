// https://leetcode.com/problems/last-day-where-you-can-still-cross

class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        
        int len = cells.length;
        int st=0, ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st+1)/2;
            
            boolean bool = isOk(row, col, cells, mid);
            
            if(bool){
                st = mid;
            }else
                ed= mid-1;
        }
        
        return isOk(row, col, cells, st) ? st+1 : 0 ;
        
        
        
    }
    
    
    private boolean isOk(int row, int col, int[][]cells, int mid){
        
        int[][] grid = new int[row][col];
        for(int i=0; i<=mid; i++){
            
            int[] cell = cells[i];
            int y = cell[0]-1;
            int x = cell[1]-1;
            grid[y][x] = 1;
            
        }
        
        
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0} ,{0,-1}};
        
        Queue<int[]> q = new LinkedList<>();
        
        boolean[][] seen = new boolean[row][col];
        
        for(int j=0; j<col; j++){
            if(grid[0][j]==0){
                q.offer(new int[]{0, j});
                seen[0][j]=true;
            }
        }
        
        
        
        
        
        while(!q.isEmpty()){
            
            for(int i=q.size(); i>0; i--){
                
                int[] p = q.poll();
                
                for(int[] d: dirs){
                    
                    int r = d[0] + p[0];
                    int c = d[1] + p[1];
                    
                    if(r<0 || c<0 || r>=row || c>=col || seen[r][c] || grid[r][c]==1)
                        continue;
                    
                    if(r==row-1)
                        return true;
                    
                    seen[r][c]=true;
                    q.offer(new int[]{r,c});
                }
            }
        }
        
        return false;
        
        
        
        
        
        
        
        
        
    }
}