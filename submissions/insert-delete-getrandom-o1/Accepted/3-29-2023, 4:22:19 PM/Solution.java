// https://leetcode.com/problems/insert-delete-getrandom-o1

class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    
    public RandomizedSet() {
        list=new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
        
        if(map.containsKey(val))
            return false;
        
        list.add(val);
        map.put(val, list.size()-1);
        
        
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int rmIdx = map.get(val);
        map.remove(val);
        int last = list.get(list.size()-1);
        
        if(val==last){
            list.remove(list.size()-1);
            return true;
        }
        
        list.remove(list.size() - 1);
        list.set(rmIdx, last); 
        map.put(last, rmIdx);
        
        return true;
    }
    
    public int getRandom() {
        return list.get((int) (Math.random()*map.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */