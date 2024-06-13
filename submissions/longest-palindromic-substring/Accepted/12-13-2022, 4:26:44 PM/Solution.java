// https://leetcode.com/problems/longest-palindromic-substring

class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        
        String res = "";
        
        
        
        
        for(int i=0; i<len; i++){
            
            String odd = extend(s, i, i);
            if(odd.length()>res.length())
                res=odd;
            
            String even = extend(s, i, i+1);
            if(even.length()>res.length())
                res=even;
            
        }
        
        return res;
        
    }
    
    
    private String extend(String s, int i, int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        
        
         return s.substring(i+1, j);
    }
}