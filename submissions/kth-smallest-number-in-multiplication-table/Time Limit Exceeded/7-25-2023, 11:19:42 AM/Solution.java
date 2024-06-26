// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table

class Solution {
    public int findKthNumber(int m, int n, int k) {
        
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0]-b[0]
        );
            
        
        for(int i=1; i<=m; i++){
            pq.offer(new int[]{i, i, 1});
        }
        
        while(!pq.isEmpty()&& k>1){
            
            int[] p = pq.poll();
            int val = p[0];
            int i = p[1];
            int j = p[2];
            
            // System.out.println(val+ " " + i + " " + j);            
            
            if(j+1<=n){
                pq.offer(new int[]{i*(j+1), i, j+1});
            }
            
            k--;
        }
        
        return pq.peek()[0];
                                                     
        
    }
}