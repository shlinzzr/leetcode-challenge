// https://leetcode.com/problems/backspace-string-compare

class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder sb = new StringBuilder();
        
        for(char c : s.toCharArray()){
            
            if(c=='#')
                if(sb.length()>0)
                sb.deleteCharAt(sb.length());
            else
                sb.append(c);
        }
        
        StringBuilder sb2 = new StringBuilder();
        for(char c : t.toCharArray()){
            
            if(c=='#')
                if(sb2.length()>0)
                sb2.deleteCharAt(sb2.length());
            else
                sb2.append(c);
        }
        
        return sb.toString().equals(sb2.toString());
    }
}