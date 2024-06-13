// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int len = nums.length;
        
        for(int i=1; i<len; i++){
            nums[i] += nums[i-1];
        }
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int max = 0;
        
        for(int i=0; i<len; i++){
            
            if(map.containsKey(nums[i]-k))
                max = Math.max(max, i-map.get(nums[i]-k));
            
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
        }
        
        return max;
        
        
    }
      
}