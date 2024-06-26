// https://leetcode.com/problems/check-if-point-is-reachable

class Solution {
    public boolean isReachable(int targetX, int targetY) {
        int g = gcd(targetX, targetY);
        return (g & (g - 1)) == 0; // check g is power of 2
    }
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}