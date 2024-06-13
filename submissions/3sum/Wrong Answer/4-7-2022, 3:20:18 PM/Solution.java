// https://leetcode.com/problems/3sum

class Solution {
    // public List<List<Integer>> threeSum(int[] nums) {
    //     Arrays.sort(nums);
    //     ArrayList<List<Integer>> rtArr = new ArrayList<List<Integer>>();
    //     for(int i=0; i<nums.length-1; i++){
    //         int ni = nums[i];
    //         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    //         for(int j=i+1; j<nums.length; j++){
    //             ArrayList<Integer> resArr = new ArrayList<>();
    //             int comp = -ni - nums[j];
    //             if(map.containsKey(comp)){
    //                 resArr.add(nums[i]);
    //                 resArr.add(map.get(comp));
    //                 resArr.add(nums[j]);
    //                 if(!rtArr.contains(resArr))
    //                     rtArr.add(resArr);
    //             }
    //             map.put(nums[j], nums[j]);
    //         }
    //     }
    //     return rtArr;
    // }
    // Time Limit Exceeded
    
    
    public List<List<Integer>> threeSum(int[] nums) {
            
        if(nums.length<3)
            return Collections.emptyList();
            
        Set<List<Integer>> res  = new HashSet<>();
        
        Arrays.sort(nums);
        // ArrayList<List<Integer>> rtArr = new ArrayList<List<Integer>>();
        for(int i=0; i<nums.length-1; i++){
            int j=i+i;
            int k = nums.length-1;
            
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum==0)
                    res.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
                else if (sum<0)
                    j++;
                else if (sum>0)
                    k--;
            }
        
        }
        return new ArrayList<>(res);
    }
    
}