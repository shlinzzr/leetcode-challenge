// https://leetcode.com/problems/largest-3-same-digit-number-in-string

class Solution {
    public String largestGoodInteger(String num) {
          int len = num.length();
        
        char[] m = num.toCharArray();
        for(int i=0; i<len-2; i++){
            if(m[i]==m[i+1] && m[i+1]==m[i+2])
               return num.substring(i, i+3);
        }
        
        return "";
    }
}
