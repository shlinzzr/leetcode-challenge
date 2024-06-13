// https://leetcode.com/problems/string-transforms-into-another-string

class Solution {
    public boolean canConvert(String str1, String str2) {
        
        
        if(str1.equals(str2))
            return true;
        
        HashMap<Character, Character> map = new HashMap<>();
        
        
        int len = str1.length();
        for(int i=0; i<len; i++){
            
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            
            if(map.containsKey(ch1) && map.get(ch1)==ch2)
                continue;
            
            if(map.containsKey(ch1) && map.get(ch1)!=ch2)
                return false;
            
            
            if(!map.containsKey(ch1)){
                map.put(ch1, ch2);
            }
            
        }
        
        return new HashSet<>(map.values()).size()<26;
    }
}