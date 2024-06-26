// https://leetcode.com/problems/evaluate-division

class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] vals, List<List<String>> q) {
        
        //https://leetcode.com/problems/evaluate-division/discuss/88169/Java-AC-Solution-using-graph 
        
        Map<String, Map<String, Double>> m = new HashMap<>();
        for (int i = 0; i < vals.length; i++) {
            m.putIfAbsent(eq.get(i).get(0), new HashMap<>());
            m.putIfAbsent(eq.get(i).get(1), new HashMap<>());
            m.get(eq.get(i).get(0)).put(eq.get(i).get(1), vals[i]);
            m.get(eq.get(i).get(1)).put(eq.get(i).get(0), 1 / vals[i]);
        }
        double[] r = new double[q.size()];
        for (int i = 0; i < q.size(); i++)
            r[i] = dfs(q.get(i).get(0), q.get(i).get(1), 1, m, new HashSet<>());
        return r;
    }

    private  double dfs(String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
        if (!m.containsKey(s) || !seen.add(s)) return -1;
        if (s.equals(t)) return r;
        Map<String, Double> next = m.get(s);
        for (String c : next.keySet()) {
            double result = dfs(c, t, r * next.get(c), m, seen);
            if (result != -1) return result;
        }
        return -1;
    }
}