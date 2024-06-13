// https://leetcode.com/problems/peak-index-in-a-mountain-array

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int len = arr.length;
        
        int st= 0, ed=len-1;
        
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(arr[mid]>arr[mid+1]){
                st = mid+1;
                
            }else 
                ed = mid-1;
        }
        
        return st;
        
        
    }
}