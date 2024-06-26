// https://leetcode.com/problems/continuous-subarray-sum

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // (mod, idx);
        int sum = 0;
        
        for(int i=0; i<nums.length;i++){
            
            int n = nums[i];
            sum+=n;
            int m = sum%k;
            
            if(map.containsKey(m) && i-map.get(m)>2){
                return true;
            }
            
            map.put(m, i);
        }
        
        return false;
        
    }
}