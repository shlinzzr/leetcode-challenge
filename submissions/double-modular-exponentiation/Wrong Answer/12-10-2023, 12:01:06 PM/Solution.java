// https://leetcode.com/problems/double-modular-exponentiation

class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> res = new ArrayList<>();
        
        int len = variables.length;
        
        for(int i=0; i<len; i++){
            int[] var = variables[i];
            int a = var[0];
            int b = var[1];
            int c = var[2];
            int m = var[3];
            
            //((ai^bi % 10)^ci) % mi == target + x*m
            long ans = quickPow(a,b)%10;
            ans =quickPow(ans, c)%m;
            
            if(ans==target) res.add(i);
            
        }
        
        return res;
    }
    
     private static long quickPow(long x, long n){   
        if (n == 0) {
            return 1;
        }
         
         int M = (int )1e9+7;
        
        long y = quickPow(x, n / 2) % M;
        
        return n % 2 == 0 ? (y * y % M) : (y * y % M * x % M);
    }
}