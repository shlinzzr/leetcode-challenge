// https://leetcode.com/problems/kth-missing-positive-number

class Solution {
    public int findKthPositive(int[] A, int k) {
      
        int len = A.length;
        
        // missing number cnt = A[idx] - (idx+1);
        // [1,2,3,4,5]
        // [1,2,4,5]    missing number=  A[2]-(2+1) = 1 
        //https://www.youtube.com/watch?v=IxL84RRkARw
        
        int st=0, ed=len;
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(A[mid]-(mid+1) < k){
                st=mid+1;
            }else{
                ed= mid;
            }
            
        }
        
        return st+k;
        
    }
}