// https://leetcode.com/problems/most-popular-video-creator

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
        HashMap<String, Integer> cntMap = new HashMap<>();
        int len = ids.length;
        
        
            
        int max = 0;
        List<String> maxList = new ArrayList<>();
            
        for(int i=0; i<len; i++){
            cntMap.put(creators[i], cntMap.getOrDefault(creators[i], 0)+views[i]);
            
            if(cntMap.get(creators[i])>max){
                max = cntMap.get(creators[i]);
                maxList = new ArrayList<>();
            }
            
            if(cntMap.get(creators[i])==max){
                
//                 List<String> list = new ArrayList<>();
//                 list.add(creators[i]);
//                 list.add(ids[i]);
                
                maxList.add(creators[i]);
            }
        }
        
        HashSet<String> set = new HashSet<>();
        
        List<List<String>> res = new ArrayList<>();
        for(int i=0; i<len; i++){
            if(maxList.contains(creators[i]) && !set.contains(creators[i])){
                List<String> list = new ArrayList<>();
                list.add(creators[i]);
                list.add(ids[i]);
                set.add(creators[i]);
                
                res.add(list);
            }
            
        }
        
        
        
        return res;
        
    }
}