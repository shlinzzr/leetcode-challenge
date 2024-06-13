// https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k

class Solution {
    public int shortestSubarray(int[] nums, int k) {  
        // practice

        int len = nums.length;
        // subarray sum 先想到presum

        long[] presum = new long[len];
        for(int i=0; i<len; i++){
            presum[i] = i==0 ? nums[i] : nums[i]+presum[i-1];
        }

        long min = len+1;

        Deque<long[]> dq = new ArrayDeque<>(); // idx, val

        for(int i=0; i<len; i++){

            if(presum[i]>=k){
                min = Math.min(min, i+1);
            }

            while(!dq.isEmpty() && dq.peekLast()[1]>=presum[i]){
                dq.pollLast();
            }

            // 0 1 2 3 4
            while(!dq.isEmpty() && presum[i]-dq.peek()[1]>=k){
                min = Math.min(min, i-dq.poll()[0]);
            }

            dq.offer(new long[]{i, presum[i]});
        }

        return (int)min==len+1 ? -1 : (int)min;






















        // // 1. base case 不要忘了
        // // 2. 算shortest 的距離要清楚
        // // 3. integer overflow  

        // // subarray sum 直接想到presum 
        // int len = nums.length;
        // long[] presum = new long[len];
        // for(int i=0; i<len; i++){
        //     presum[i] = i==0 ? nums[0] : nums[i] + presum[i-1];
        // }
        
        // // find sliding window minimum

        // Deque<Integer> dq = new ArrayDeque<>(); //  idx
        // int min = len+1;

        // for(int i=0; i<len; i++){

        //     long cur = presum[i];
        //     // base case 
        //     if(cur>=k) min = Math.min(min, i+1);

        //     // the cur is smaller than previous insert element
        //     // means the cur is more opptunity fullfill k and will be more shorter
        //     while(!dq.isEmpty() && cur<=presum[dq.peekLast()]){
        //         dq.pollLast();
        //     }

        //     while(!dq.isEmpty() && cur-presum[dq.peek()]>=k ){
        //         min = Math.min(min, i-dq.poll());
        //     }

        //     dq.offer(i);

        // }        

        // return min==len+1? -1 : min;


        // int len = nums.length;
        // long[] presum = new long[len];
        // for(int i=0; i<len; i++){
        //     presum[i] = i==0L ? (long)nums[0] : presum[i-1] + (long)nums[i];
        // }


        // // 找 shortest
        // // nums  2 -1 2
        // // presum 2 1 3
        // //        i. cur  : --> peek(i) presum[cur]-presum[i] >= k  有的話就pop() 求min
        // // poll() ---->找近的i 
        // // 除此之外 要把前面比自己大的cur都幹掉 
        // // 因為自己相對於前面 presum更小的話 更容易滿足k 也更近
        // // 如果沒做 容易把自己卡在前面 沒滿足K 掛在半路上
        // Deque<Integer> dq = new ArrayDeque<Integer>();
        // int min = len+1;
        // for(int i=0; i<len; i++){
        //     long cur = presum[i];

        //     //base case : presum[i]直接>＝k min: nums[0:i], 長度i+1
        //     if(cur>=k){ 
        //         min = Math.min(min, i+1);
        //     }

        //     //這才是關鍵 把前面候選人幹掉 對於上一個加入的 peekLast來說
        //     // 如果 cur<= presum[peeklast()] 表示我sum更小, presum[i]來減更容易達成k 更靠近i陣列長度也會更小
        //     while(!dq.isEmpty() && cur<=presum[dq.peekLast()]){
        //         dq.pollLast();
        //     }

        //     // 從左向右邊 往 shortest i 逼近
        //     // 已經達成k, 過小&過遠的 head poll掉
        //     while(!dq.isEmpty() && cur-presum[dq.peek()]>=k){
        //         min = Math.min(min, i-dq.poll());
        //     }


        //     dq.offer(i);
        // }

        // return min==len+1 ? -1 : min;
        
    }
}