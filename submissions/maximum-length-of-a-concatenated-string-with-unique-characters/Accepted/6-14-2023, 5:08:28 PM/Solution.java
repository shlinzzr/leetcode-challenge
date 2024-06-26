// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters

class Solution {
    
    int max = 0;
    
    public int maxLength(List<String> arr) {
        
        List<String> res = new ArrayList<>();
        
        
        helper(arr, res , "", 0);
        int max = 0; 
        
        for(String r : res){
            max = Math.max(max, r.length());
        }
        
        
        return max;
    }
    
    private void helper(List<String> arr,List<String> res , String curr, int st ){
        
        if(st>=arr.size())
            return;
        
        for(int i=st; i<arr.size(); i++){
             int[] check = new int[26];
            
             for(char ch : curr.toCharArray()){
                check[ch-'a']++;
             }
            
            for(char ch : arr.get(i).toCharArray()){
                check[ch-'a']++;
            }
            
            boolean dul = false;
            for(int c: check){
                if(c>1){
                    dul=true;
                }
            }
            
            if(dul==false){
                res.add(curr+arr.get(i));
                helper(arr, res, curr+arr.get(i), i+1);
            }
        }
    }
}