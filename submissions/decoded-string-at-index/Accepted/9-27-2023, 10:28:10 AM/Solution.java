// https://leetcode.com/problems/decoded-string-at-index

class Solution {
    public String decodeAtIndex(String S, int K) {
        
        long curLength = 0;
        char c = 0;
        
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) { // a1
                curLength *= c - '0';
            }
            else { // b1
                curLength++;
            }
        }
        
        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if (Character.isDigit(c)) { // a2
                curLength /= c - '0';
                K %= curLength;
            }
            else { // b2
                if (K == 0 || K == curLength) {
                    return "" + c;
                }
                curLength--;
            }
        }
        
        throw null;
    }
}