// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    
    int res = 0;
    
    public int subarraySum(int[] nums, int k) {
        
        helper(nums, k , 0, 0);
        
        return res;
    }
    
    
    private boolean helper(int[] nums, int k,  int curr, int st){
        
        if(curr==k){
            res++;
            return false;
        }
        if(curr>k)
            return false;
        
        
        for(int i=st; i<nums.length; i++){
            
            boolean res = helper(nums, k, curr+nums[i], i+1); //helper(1, 1) -> helper(2,2)
            if(res==false)
                break;
        }
        
        return true;
        
        
        
        
    }
    
    
}