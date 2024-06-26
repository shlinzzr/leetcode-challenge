// https://leetcode.com/problems/ransom-note

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];

        for(char ch : ransomNote.toCharArray()){
            arr[ch-'a']++;
        }

        for(char ch : magazine.toCharArray()){
            arr[ch-'a']--;
        }

        for(int a: arr){
            if(a>0)
                return false;
        }

        return true;
    }
}