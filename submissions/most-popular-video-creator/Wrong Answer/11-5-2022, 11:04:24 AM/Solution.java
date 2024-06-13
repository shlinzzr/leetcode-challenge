// https://leetcode.com/problems/most-popular-video-creator

class Solution {
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        
         List<List<String>> res = new ArrayList<>();
        
        int len = ids.length;
        HashMap<String, String> ctid = new HashMap<>();
        TreeMap<String, Integer> ccnt = new TreeMap<>();
        TreeMap<String, Integer> ctcnt = new TreeMap<>();
        
        for(int i=0; i<len; i++){
            String creator = creators[i];
            String id = ids[i];
            int v = views[i];
            
            ctcnt.put(creator, ctcnt.getOrDefault(creator, 0)+v);
            
            if(ctid.containsKey(creator)){
                
                if(ccnt.get(creator) < v){
                     ccnt.put(creator, v);
                     ctid.put(creator, id);
                }
                
                
            }else{
                
                ctid.put(creator, id);
                ccnt.put(creator, v);
                
            }
        }
        
        
        int max = -1;
        for(Map.Entry<String, Integer> en : ctcnt.entrySet()){
            String c = en.getKey();
            int v = en.getValue();
            if(v<max)
                break;
            
            max = v;
            List<String> list = new ArrayList<>();
            list.add(c);
            list.add(ctid.get(c));
            res.add(list);
        }
        
        return res;
    }
}