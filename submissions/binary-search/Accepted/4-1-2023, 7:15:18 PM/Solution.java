// https://leetcode.com/problems/binary-search

class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int st =0, ed= len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(nums[mid]==target)
                return mid;
            else if(nums[mid]<target)
                st=mid+1;
            else 
                ed=mid-1;
        }
        return nums[st]==target? st : -1;
    }
}