// https://leetcode.com/problems/ugly-number-ii

class Solution {
   public int nthUglyNumber(int n) {
        if(n==1) return 1;
       
        PriorityQueue<Long> q = new PriorityQueue();
        q.add(1l);

        for(long i=1; i<n; i++) {
            long tmp = q.poll();
            while(!q.isEmpty() && q.peek()==tmp) tmp = q.poll();

            q.add(tmp*2);
            q.add(tmp*3);
            q.add(tmp*5);
        }
        return q.poll().intValue();
    }
}