// https://leetcode.com/problems/substring-with-concatenation-of-all-words

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<String> list = new ArrayList<>();
        
        int len = words.length;
        boolean[] used = new boolean[len];
        
        dfs(words, "", list, used);
        
        System.out.println(list.size());
        
        Set<Integer> res = new HashSet<>();
        
        for(String l : list){
            
            int idx = s.indexOf(l);
            while(idx>=0){
                res.add(idx);
                idx = s.indexOf(l, idx+1);
            }
        }
        
        return new ArrayList<>(res);
        
    }
    
    
    private void dfs(String words[], String curr, List<String> list, boolean[] used){
        
        int wLen = words[0].length();
        int len = words.length;
        if(curr.length()==wLen*len){
            list.add(curr);
            return;
        }
        
        
        for(int i=0; i<len; i++){
            if(used[i]==false){
                used[i]=true;
                dfs(words, curr+words[i], list, used);
                used[i]=false;
            }
        }
        
        
    }
}