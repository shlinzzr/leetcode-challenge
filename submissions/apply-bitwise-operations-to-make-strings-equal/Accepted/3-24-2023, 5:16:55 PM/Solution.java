// https://leetcode.com/problems/apply-bitwise-operations-to-make-strings-equal

class Solution {
    public boolean makeStringsEqual(String s, String t) {
         return s.contains("1") == t.contains("1");
    }
}