// https://leetcode.com/problems/range-sum-query-mutable

class NumArray {

    class SegmentTreeNode {
        int start, end;
        SegmentTreeNode left, right;
        int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
      
    SegmentTreeNode root = null;
    
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length-1);
    }
    
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if(start>end)
            return null;
        else{
            SegmentTreeNode ret = new SegmentTreeNode(start, end);
            if(start==end){
                ret.sum = nums[start];
            }else{
                int mid = start + (end-start)/2;
                ret.left=buildTree(nums, start, mid);
                ret.right = buildTree(nums, mid+1, end);
                ret.sum = ret.left.sum + ret.right.sum;
            }
            
            return ret;
        }
          
    }
    
    
    public void update(int index, int val) {
        update(root, index, val);
    }
    
    private void update(SegmentTreeNode root, int idx, int val) {
        if(root.start==root.end)
            root.sum=val;
        else{
            int mid = root.start + (root.end - root.start) / 2;
            if (idx <= mid) {
                 update(root.left, idx, val);
            }else{
                 update(root.right, idx, val);
            }
            
            root.sum = root.left.sum + root.right.sum;
        }
       
    }
    
    
    public int sumRange(int left, int right) {
         return sumRange(root, left, right);
    }
        
        
    public int sumRange(SegmentTreeNode root, int start, int end) {
        if (root.end == end && root.start == start) {
            return root.sum;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (end <= mid) {
                return sumRange(root.left, start, end);
            } else if (start >= mid+1) {
                return sumRange(root.right, start, end);
            }  else {    
                return sumRange(root.right, mid+1, end) + sumRange(root.left, start, mid);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */