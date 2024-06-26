// https://leetcode.com/problems/range-module

class RangeModule {

    TreeMap<Integer, Integer> map;

    public RangeModule() {

        map = new TreeMap<>();
        
    }
    
    public void addRange(int left, int right) {

        if(right<=left) return;

        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if(start==null && end==null){
            map.put(left, right);
        }else if(start!=null && map.get(start)>left){ //start and end is not null
            map.put(start, Math.max(map.get(start), Math.max( map.get(end), right)));
        }else { // start==null, end!=null
            map.put(left, Math.max(right, map.get(end)));
        }

        Map<Integer, Integer> sub = map.subMap(left, false, right, true);
        map.keySet().removeAll(sub.keySet());
        
    }
    
    public boolean queryRange(int left, int right) {

        Integer start = map.floorKey(left);
        if(start==null) return false;
        return map.get(start)>=right;
        
    }
    
    public void removeRange(int left, int right) {

        if(right<=left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if(end!=null && map.get(end)> right){
            map.put(right, map.get(end));
        }
        if(start!=null && map.get(start)>left){
            map.put(start, left);
        }

        Map<Integer, Integer> sub = map.subMap(left, true, right, false);
        map.keySet().removeAll(sub.keySet());
        
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */