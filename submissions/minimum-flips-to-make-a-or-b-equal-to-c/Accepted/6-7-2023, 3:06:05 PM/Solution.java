// https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c

class Solution {
    public int minFlips(int a, int b, int c) {
        int answer = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    answer++;
                }
            } else {//c==0
                answer += (a & 1) + (b & 1);
            }
            
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        
        return answer;
    }
}