// https://leetcode.com/problems/climbing-stairs

class Solution {
    public int climbStairs(int n) {
        
        if(n<=3)
            return n;
        
        return climbStairs(n-1) + climbStairs(n-2); 
    }
}