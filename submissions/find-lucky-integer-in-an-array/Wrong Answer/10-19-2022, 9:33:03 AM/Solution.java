// https://leetcode.com/problems/find-lucky-integer-in-an-array

class Solution {
    public int findLucky(int[] arr) {
        int[] t = new int[501];
        for(int a : arr){
            t[a]++;
        }
        
        for(int i=1; i<501; i++){
            if(t[i]==i)
                return i;
        }
        
        return -1;
    }
}