// https://leetcode.com/problems/max-value-of-equation

class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        int len = points.length;

        int res = Integer.MIN_VALUE;

        // for point(i, j)
        // find max yi + yj - xi + xj 
        // 固定j xj+yj find max of i :  yi-xi
        // if i, j distance > k, pop i


        // dq  head ======= last

        for(int j=0; j<len; j++){

            while(!dq.isEmpty() && points[j][0] - points[dq.peekFirst()][0] > k){
                dq.pollFirst();
            }

            if(!dq.isEmpty()){

                int[] f = points[dq.peekFirst()];
                int val = -f[0] + f[1] +points[j][0] + points[j][1];
                res = Math.max(res, val);
            }

            while(!dq.isEmpty() &&  -points[dq.peekLast()][0] + points[dq.peekLast()][1] < -points[j][0] + points[j][1]){
                dq.pollLast();
            }

            dq.add(j);


        }

        return res;

    }
}