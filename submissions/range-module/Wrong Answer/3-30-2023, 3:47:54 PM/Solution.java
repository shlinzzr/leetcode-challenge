// https://leetcode.com/problems/range-module

class RangeModule {
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if (start == null && end == null) {
            map.put(left, right);
        } else if (start != null ) {
            map.put(start, Math.max(map.get(end), Math.max(map.get(start), right)));
    	}
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, false, right, true);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
    }
    
    public boolean queryRange(int left, int right) {
        Integer start = map.floorKey(left);
        if (start == null) return false;
        return map.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        if (right <= left) return;
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
    	if (end != null && map.get(end) > right) {
            map.put(right, map.get(end));
    	}
    	if (start != null && map.get(start) > left) {
            map.put(start, left);
    	}
        // clean up intermediate intervals
        Map<Integer, Integer> subMap = map.subMap(left, true, right, false);
        Set<Integer> set = new HashSet(subMap.keySet());
        map.keySet().removeAll(set);
        
    }
}