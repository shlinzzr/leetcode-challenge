// https://leetcode.com/problems/power-of-two

class Solution {
    public boolean isPowerOfTwo(int n) {
        
        
        while(n>=1){
            
            
            if(n==1)
                return true;
            if(n%2==1)
                return false;
            
            n = n>>1;      
            System.out.println(n);
          
        }
        return false;
    }
}