// https://leetcode.com/problems/minimum-array-length-after-pair-removals

class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        
//         int len = nums.size();
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int n : nums){
//             map.put(n, map.getOrDefault(n,0)+1);
//         }
        
//         List<Integer> list = new ArrayList<>(map.keySet());
//         int prev = map.get(list.get(0));
//         for(int i=1; i<list.size(); i++){
            
//         }
        
        
        
        
        int len = nums.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            (a,b)-> b.getValue()-a.getValue()
        );
        // pq.addAll(map.entrySet());
        
        
      
        
        // HashSet<Integer> rm = new HashSet<>();
        
//         HashMap<Integer, List<Integer>> valmap = new HashMap<>();
//         for(Map.Entry<Integer, Integer> en : map.entrySet()){
            
//             int k = en.getKey();
//             int v = en.getValue();
            
//             valmap.putIfAbsent(v, new ArrayList<>());
//             valmap.get(v).add(k);
//             if(valmap.get(v).size()>=3 && v%2==0)
//                 // rm.addAll(valmap.get(v));
//                 rm.add(v);
//         }
        
        // System.out.println(valmap.values());
        //  System.out.println(rm);
        
        
//         HashMap<Integer, Integer> tmp = new HashMap<>();
        
//         for(Map.Entry<Integer, Integer> en : map.entrySet()){
             
//             int k = en.getKey();
//             int v = en.getValue();
            
//             if(rm.contains(v))
//                 continue;
//             else
//                 tmp.put(k,v);
            
//         }
        
        pq.addAll(map.entrySet());
        
        // 2 2 2 3 3 3 4 4 4
        // 23 24 34
        
        while(pq.size()>=2){
            Map.Entry<Integer, Integer> en1 = pq.poll();
            Map.Entry<Integer, Integer> en2 = pq.poll();
            
            // System.out.println(en1.getKey() + " " + en1.getValue()+ " ..."+ en2.getKey() + ":"+en2.getValue());
            
            // if(en1.getValue()==en2.getValue()){
                 en1.setValue(en1.getValue()-1);
                en2.setValue(en2.getValue()-1);
                
                if(en1.getValue()>0)
                  pq.offer(en1);
                 if(en2.getValue()>0)
                 pq.offer(en2);
                
//             }else if(en1.getValue()>en2.getValue()){
//                 en1.setValue(en1.getValue()-en2.getValue());
//                 pq.offer(en1);
                
//             }else if(en2.getValue()>en1.getValue()){
//                 en2.setValue(en2.getValue()-en1.getValue());
//                 pq.offer(en2);
            // }
        }
        
        if(pq.size()==0)
            return 0;
        
        return pq.peek().getValue();
    }
    
    //[1,1,2,2,3,3,3]
}