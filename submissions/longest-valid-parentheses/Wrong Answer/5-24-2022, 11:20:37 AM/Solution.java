// https://leetcode.com/problems/longest-valid-parentheses

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack();
        
        String maxStr = "";
        
        String currStr = "";
        
        
        for(char c : s.toCharArray()){
            // System.out.println("c="+c);
            
            if( c=='('){
                // System.out.println("stack.push(c);");
                stack.push(c);
                currStr+=c;
                
            }else{ // c==')'
                if(!stack.isEmpty()){
                    char ele = stack.pop();
                     // System.out.println("ele="+ele);
                    if(ele=='(') // valid                        
                        currStr+=c;
                    
                    else{
                        if(currStr.length()> maxStr.length())
                            maxStr =  currStr;
                        currStr = "";
                    }
                 }
            }
            System.out.println("currStr="+currStr);
        }
        
        if(currStr.length()> maxStr.length())
            maxStr =  currStr;
        
        
        return  maxStr.length();
            
        
    }
}