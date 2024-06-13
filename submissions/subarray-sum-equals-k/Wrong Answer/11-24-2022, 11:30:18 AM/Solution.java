// https://leetcode.com/problems/subarray-sum-equals-k

class Solution {
    
    int res = 0;
    
    public int subarraySum(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        int sum =0, res=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k))
                res+=map.get(sum-k);
            else
                map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        
        return res;
        
    }
    
    
}