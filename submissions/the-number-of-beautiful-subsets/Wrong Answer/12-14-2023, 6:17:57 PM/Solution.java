// https://leetcode.com/problems/the-number-of-beautiful-subsets

class Solution {

    public int beautifulSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        List<List<Integer>> res= new ArrayList<>();
        helper(nums, 0, new ArrayList<>(), res, k);
        System.out.println(res);

        return res.size();
    }

    private void helper(int[] nums, int idx, List<Integer> curr, List<List<Integer>> res, int k){

        if(!curr.isEmpty()){
            res.add(new ArrayList<>(curr));
        }

        for(int i=idx; i<nums.length; i++){
            if(curr.isEmpty() || Math.abs(curr.get(curr.size()-1)-nums[i])!=k){
                curr.add(nums[i]);
                helper(nums, i+1, curr, res, k);
                curr.remove(curr.size()-1);
            }
        }

    }
}