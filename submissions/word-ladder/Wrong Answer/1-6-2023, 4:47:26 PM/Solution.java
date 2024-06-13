// https://leetcode.com/problems/word-ladder

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, List<String>> map = new HashMap<>();
        findNeb(beginWord, wordList, map);
        for(String w : wordList){
            findNeb(w, wordList, map);
        }
        
        HashSet<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        seen.add(beginWord);
        int step=0;
        while(!q.isEmpty()){
            for(int i=q.size(); i>0; i--){
                
                String p = q.poll();
                List<String> nebs = map.get(p);
                for(String n : nebs){
                    if(seen.contains(n))
                        continue;
                    
                    seen.add(n);
                    q.offer(n);
                }
            }
            step++;
        }
        
        return step;
        
        
    }
    
    
    
    private void findNeb(String s, List<String> wordList, HashMap<String, List<String>> map){
        
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }
        
        map.put(s, new ArrayList<>());
        
        int[] tmp = new int[26];
        for(String w : wordList){
            
            System.arraycopy(arr, 0, tmp, 0, 26);
            
            for(char ch : w.toCharArray()){
                tmp[ch-'a']--;
            }
            
            int diff=0;
            for(int t : tmp){
                if(t!=0)
                    diff++;
                if(diff>2)
                    continue;
            }
            
            if(diff<=2 && diff!=0)
                map.get(s).add(w);
        }
        
    }
}