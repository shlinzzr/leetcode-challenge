// https://leetcode.com/problems/maximum-69-number

class Solution {
    public int maximum69Number (int num) {
        return Integer.valueOf((num+"").replaceFirst("6", "9"));
    }
}