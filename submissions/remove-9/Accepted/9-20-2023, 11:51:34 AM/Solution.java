// https://leetcode.com/problems/remove-9

class Solution {
    public int newInteger(int n) {
        // int ans = 0;
        // int base = 1;
            
        // while (n > 0){
        //     ans += n % 9 * base;
        //     n /= 9;
        //     base *= 10;
        // }
        // return ans;

        return Integer.parseInt(toNdigit(n, 9));
    }


    private String toNdigit(int n, int d){
        String result="";
        String remain = "";

        while(n>=d){
            remain = String.valueOf(n%d);
            n /= d;
            result = remain + result;
        }

        return String.valueOf(n) + result;
    }

}