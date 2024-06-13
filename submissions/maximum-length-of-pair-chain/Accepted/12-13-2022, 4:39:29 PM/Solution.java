// https://leetcode.com/problems/maximum-length-of-pair-chain

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a,b)-> a[0]-b[0]==0?a[1]-b[1]:a[0]-b[0]);
        
        for(int[] p : pairs){
            System.out.println("["+p[0]+","+p[1]+"],");
        }
        
        int cnt=1;
        for(int i=0; i<pairs.length-1; i++){
            if(pairs[i][1]<pairs[i+1][0])
                cnt++;
            else{
                pairs[i+1][1] = Math.min(pairs[i+1][1], pairs[i][1]);
            }
            
        }
        
        return cnt;
    }
}