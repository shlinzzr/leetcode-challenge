// https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array

class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = firstOccur(nums, target);
        int plusNBy2Index = firstIndex + nums.length/2;
        
        if (plusNBy2Index<nums.length 
            && nums[plusNBy2Index] == target) {
            return true;
        }
        
        return false;
    }
    
    private int firstOccur(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high-low)/2;
            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] >= target) high = mid;
        }
        return low;
    }
    
}