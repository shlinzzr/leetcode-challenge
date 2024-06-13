// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
     
        
        int st=0, ed = nums.length-1;
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]>target)
                ed = mid;
            else 
                st = mid +1;
        }
        
        return -1;
        
        
    }
}