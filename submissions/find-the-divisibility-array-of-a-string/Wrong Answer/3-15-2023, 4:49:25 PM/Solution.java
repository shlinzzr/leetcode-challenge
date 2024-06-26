// https://leetcode.com/problems/find-the-divisibility-array-of-a-string

class Solution {
    public int[] divisibilityArray(String word, int m) {
        
        
        int len = word.length();
        
        int[] res = new int[len];
        long sum = 0;
        for(int i=0; i<len; i++){
            int digit = word.charAt(i)-'0';
            sum = sum*10 + digit;
            res[i] = (sum%m==0) ? 1: 0;
            
        }
        
        return res;
    }
}