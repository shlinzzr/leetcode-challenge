// https://leetcode.com/problems/convert-the-temperature

class Solution {
    public double[] convertTemperature(double celsius) {
        double[] res = new double[2];
        res[0] = celsius + 273.15;
        res[1] = celsius * 1.80 + 32;
        return res;
    }
}