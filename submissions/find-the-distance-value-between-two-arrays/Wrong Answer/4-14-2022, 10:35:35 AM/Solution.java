// https://leetcode.com/problems/find-the-distance-value-between-two-arrays

class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int distance =0;
        
        for(int i=0;i<arr1.length; i++){
            
            distance = i;
            
            for(int a2 : arr2){
                
                
                if(Math.abs(arr1[i]-a2)>d)
                    continue;
                else 
                    return i;
            }
            
            
        }
        return distance ;
    }
}