// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        
        
        
        int st=0, ed=arr.length-k-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
//             if(arr[mid]==x){
//                 st=mid;
//                 break;
                
//             }else 
                if(x-arr[mid]>arr[mid+k]-x){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        for(int i=0; i<k; i++){
            res.add(arr[st]);
            st++;
        }
        
        
        
        
        
        Collections.sort(res);
        
        return res;
            
    }
    
}