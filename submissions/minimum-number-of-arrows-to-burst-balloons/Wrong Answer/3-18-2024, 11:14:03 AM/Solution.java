// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons

class Solution {
    public int findMinArrowShots(int[][] points) {

        int len = points.length;
        Arrays.sort(points, (a,b)-> a[0]!=b[0] ? a[0]-b[0] : a[1]-b[1]);

        int[] prev = points[0];
        int cnt = 1 ;

        for(int i=1; i<len; i++){
            int[] curr = points[i];

            if(curr[0] <= prev[1]){
                prev[1] = Math.min(curr[1], prev[1]);

            }else{
                cnt++;
                prev = curr;
            }   
        }

        return cnt;

        
    }
}