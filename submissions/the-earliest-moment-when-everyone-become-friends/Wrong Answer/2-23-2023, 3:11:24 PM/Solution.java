// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends

class Solution {
    
    int[] parent;
    public int earliestAcq(int[][] logs, int n) {
        parent = new int[n];
        int cnt = n;
        int max = 0;
        for(int i=0; i<n; i++) parent[i] = i;
        
        
        for(int[] log : logs){
            
            int time = log[0];
            
            int root = find(log[1]);
            int node = find(log[2]);
            
            if(root!=node){
                parent[node]=root;
                max = Math.max(max, log[0]);
                cnt--;
                
                if(cnt==1)
                    return max;
            }
        }
        
        return max;
        
        
        
    }
    
    
    private int find(int x){
        if(parent[x]==x)
            return x;
        parent[x] = find(parent[x]);
        return parent[x];
    }
}