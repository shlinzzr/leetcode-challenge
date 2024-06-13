// https://leetcode.com/problems/exclusive-time-of-functions

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) { // 這裡同時最多兩個task, stack depth 最多是1 所以只要peek就好
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }
        
        return result;
    }
    
    public static class Log {
        public int id;
        public boolean isStart;
        public int time;
        
        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
}