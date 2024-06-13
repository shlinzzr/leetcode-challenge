// https://leetcode.com/problems/find-pivot-index

class Solution {
    public int pivotIndex(int[] nums) {
        
        int len = nums.length;
        
        int[] presum = new int[len];
        if(len==1) return 0;
//         x x x x x x 
//             i
            
//         int left =presum [i];
//         int right = presum [len-1] - presum[i];
//         find idx i that satisfied left==right
        // [1,7,3,6,5,6]
        // presum [1 8 11 17 22 28]
        //                 m
        // left = 11, right=17
         
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[0] : presum[i-1]+nums[i];
        }
        
        
        int[] sufsum = new int[len];
        
        for(int i=len-1; i>=0; i--){
            sufsum[i] = i==len-1 ? nums[i] : sufsum[i+1] + nums[i];   
        }
        
        for(int i=0; i<len; i++){
            
            if(i==0 && sufsum[i+1]==0) return 0;
            if(i==len-1 && presum[len-2]==0) return len-1;
            
            if(i==0 || i==len-1) continue;
            if(presum[i-1]==sufsum[i+1]) return i;
            
        }
        return -1;
        
//         // x [x x x x x] ==0
//         if(presum[len-1]-presum[0]==0) return 0;
        
//         // [x x x x x ] x
//         if(presum[len-2]==0) return len-1;
        
        
//         int st =1, ed = len-2;
//         while(st<ed){ //0, 1
            
//             int mid = st+(ed-st)/2; // 0
            
//             int left = presum[mid-1];
//             int right = presum[len-1]- presum[mid];
            
//             if(left==right){
//                 return mid;
//             }else if(left<right){
//                 st = mid+1; 
//             }else{
//                 ed = mid-1;
//             }
            
//         }
//         System.out.println(st);
//         int left = presum[st-1];
//         int right = presum[len-1]- presum[st];
        
//         return left==right ? st : -1;
    }
}