// https://leetcode.com/problems/minimum-increment-operations-to-make-array-beautiful

class Solution {

    public long minIncrementOperations(int[] A, int k) {
        long dp1 = 0, dp2 = 0, dp3 = 0, dp4;

        // dp1 dp2 dp3 dp(k-a)
        //.    dp1 dp2 dp3

        for (int a: A) {
            dp4 = Math.min(dp1, Math.min(dp2, dp3)) + Math.max(k - a, 0);
            dp1 = dp2;
            dp2 = dp3;
            dp3 = dp4;
        }
        return Math.min(dp1, Math.min(dp2, dp3));
    }
}
/*
    public long minIncrementOperations(int[] arr, int k) {
        int len = arr.length;
        
        int[] nums = new int[len];
        System.arraycopy(arr, 0, nums, 0, len);
        
        long res = 0;
        for(int i=0; i<len-2; i++){
            
            int n1 = nums[i];
            int n2 = nums[i+1];
            int n3 = nums[i+2];
            
            int max = Math.max(n1, Math.max(n2, n3));
              // System.out.println(i + " " + max);
            if(k>max){
              
                res += k-max;
                
                if(max==n3)
                    nums[i+2]=k;
                else if(max==n2)
                    nums[i+1]=k;
      
            }
        }
        
        
         System.arraycopy(arr, 0, nums, 0, len);
        
        int res2=0;
        
        // len =4, i=1
        for(int i=len-3; i>=0; i--){
            
            int n1 = nums[i];
            int n2 = nums[i+1];
            int n3 = nums[i+2];
            
            int max = Math.max(n1, Math.max(n2, n3));
              // System.out.println(i + " " + max);
            if(k>max){
              
                res2 += k-max;
                
                if(max==n1)
                    nums[i]=k;
                else if(max==n2)
                    nums[i+1]=k;
      
            }
        }
        System.out.println(res2);
        
        return Math.min(res, res2);
        
        */
        
        
        
        
//         long res = 0;
//         int st = 0;
        
//         HashMap<Integer, Integer> idxMap = new HashMap<>();
        
//         TreeMap<Integer, Integer> map = new TreeMap<>();
//         for(int ed=0; ed<len; ed++){
//             map.put(nums[ed], map.getOrDefault(nums[ed],0)+1);
//             idxMap.put(nums[ed], ed);
            
//             if(ed<2)
//                 continue;
            
// //             System.out.println("ed="+ed + " last="+map.lastKey());
            
// //             // System.out.println("nums[1]="+nums[1]);
// //             System.out.println("idxMap.keySet()="+idxMap.get(3));
            
            
//             if(map.lastKey()<k){
//                 int last = map.lastKey();
//                 long diff = (long) (k-last);
//                 res+= diff;
//                 map.put(k, 1);
//                 nums[idxMap.get(last)] = k;
                
//                 map.put(last, map.getOrDefault(last,0)-1);
//                 if(map.get(last)==0)
//                      map.remove(last);
                
                
//             }
//             System.out.println(map.keySet());
            
//             map.put(nums[st], map.getOrDefault(nums[st],0)-1);
//             if(map.get(nums[st])==0)
//                 map.remove(nums[st]);
            
//         }
//         return res;
            
//     }
// }