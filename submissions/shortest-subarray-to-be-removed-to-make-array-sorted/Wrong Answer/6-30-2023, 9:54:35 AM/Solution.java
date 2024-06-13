// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted

class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length;
        
        
        int i=0, j =len-1;
        
        while(j>0 && arr[j-1]<=arr[j]){
            j--;
        }
        
        int min = j;
        
        if(min==0)
            return 0;
        
        
        while(i<j-1 && arr[i]<=arr[i+1]){
            
            while(j<len && arr[i]>arr[j]){
                j++;
            }
            
            min = Math.min(min, j-i-1);
            i++;
        }
        
        return min;
        
        
        
        
        
    }
    
    
}