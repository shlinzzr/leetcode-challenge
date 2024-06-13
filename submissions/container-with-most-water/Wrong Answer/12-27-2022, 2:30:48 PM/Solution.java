// https://leetcode.com/problems/container-with-most-water

class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int len = height.length;
        int st=0, ed=len-1;
        
        while(st<ed){
            
            max = Math.max(max, Math.min(height[st], height[ed]) * (ed-st));
            
            if(height[st+1]>= height[ed-1]){
                st++;
            }else 
                ed--;
            
            
        }
        
        return max;
    }
}