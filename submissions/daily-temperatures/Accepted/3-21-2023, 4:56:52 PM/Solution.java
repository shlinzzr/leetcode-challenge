// https://leetcode.com/problems/daily-temperatures

class Solution {
    public int[] dailyTemperatures(int[] T) {
        
        int len = T.length;
        int[] res = new int[len];
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            
            while(!st.isEmpty() && T[st.peek()] < T[i]){
                res[st.peek()] = i-st.peek();
                st.pop();
            }
            st.push(i);
            
        }
        
        return res;
        
    }
}