// https://leetcode.com/problems/minimum-cost-to-equalize-array

class Solution {
    public int minCostToEqualizeArray(int[] nums, int cost1, int cost2) {
        
        int M = (int) 1e9+7;

        // 數學推導題 https://www.bilibili.com/video/BV1Nf421U7em/?spm_id_from=333.999.0.0&vd_source=c9ea2869a251a096987b9bd5effa8d78

        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0 ;
        for(int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
            sum += n;
            sum %= M;
        }

        long need = max * len - sum;
        if(cost1*2<=cost2|| len<=2){ // 通通用cost1做就好了
            return (int) (need * cost1 %M);
        }

        long ans = Integer.MAX_VALUE;
        long res =0 ;
        for(int target=max; target<=max*2+1; target++){

            int d = target - min;
            if( d <= need - d){
                res = need/2 * cost2 + (need%2)*cost1; // use all cost2 with 1 (or 0) cost1
            }else
                res = (need-d)*cost2 + (d-(need-d))*cost1;

            ans = Math.min(ans, res%M);
            need += len;
        }

        return (int) (ans % M);


        
    }
}