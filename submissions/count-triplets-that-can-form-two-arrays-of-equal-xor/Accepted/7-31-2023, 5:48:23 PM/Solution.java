// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor

class Solution {
    public int countTriplets(int[] arr) {
        
        // ref huifeng O(n) https://www.youtube.com/watch?v=DwvNIVLcT8U
        int len = arr.length;
        
        int[] prexor = new int[len];
        
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // val, List<idx>
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        
        int xorsum = 0;
        int ret = 0;
        for (int k=0; k<arr.length; k++)
        {
            xorsum ^= arr[k];
            for (int i: map.getOrDefault(xorsum, new ArrayList<>()))
                ret+=k-(i+2)+1;
            
            // XX X [ X X X X X X ][X X X X]  XXX
            //    i  i+1                    k
            
            // xor==0 = prexor[k] ^ prexor[i-1]
            // ==>  prexor[i-1]==prexor[k] ^ 0
            
            // xor [i+1: k] ==0
            // j : [i+2: k] => k-(i+2)+1 == k-i-1;
            
            map.putIfAbsent(xorsum, new ArrayList<>());
            map.get(xorsum).add(k);
        }
        return ret;
        
    // 自己硬幹的 : O(n^2)
// // XXX   [ X X X X X X ][X X X X]  XXX
//       // a=i^  ...^ j-1, j ... k
        
//         // find arr where xor ==0;
        
//         int len = arr.length;
        
//         int res = 0;
        
//         for(int i=0; i<len; i++){
            
//             int xor = arr[i];
            
//             for(int j=i+1; j<len; j++){
                
//                 xor ^= arr[j];
//                 if(xor==0){
//                     res+= (j-i);// 總共有(j-i+1)個element, 切成多份且每份不為0個element有幾種切法？ => (j-i)種
//                 }
//             }
//         }
        
//         return res;
        
        
    }
}