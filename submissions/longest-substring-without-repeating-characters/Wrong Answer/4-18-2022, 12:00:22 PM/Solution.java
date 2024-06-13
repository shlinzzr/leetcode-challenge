// https://leetcode.com/problems/longest-substring-without-repeating-characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        
      
        
        char[] arr = s.toCharArray();
        int [] lenArr = new int [ arr.length];
        
        Set<Character> set = new HashSet<Character>();
        
        
        
        for( int i=0; i<arr.length; i++){
            
            set = new HashSet();
            for(int j=i; j<arr.length; j++){
                
                if(!set.contains(arr[j]))
                    set.add(arr[j]);
                else{
                    lenArr[i]= set.size();
                    break;
                }
            }
            
           
        }
        
        int max = 0;
        for(int len: lenArr){
            System.out.println(len);
            if(len>max)
                max = len;
        }
        
        return max;
        
        
    }
}