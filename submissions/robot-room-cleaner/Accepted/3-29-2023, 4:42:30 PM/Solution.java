// https://leetcode.com/problems/robot-room-cleaner

/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, 0, 0, 0, visited);
    }
    
    // [x, y] is the relative position from the initial point
    private void dfs(Robot robot, int x, int y, int curDir, Set<String> visited) {
        visited.add(x + "-" + y);
        
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int nextDir = (curDir + i) % 4;
            int newX = x + dirs[nextDir][0];
            int newY = y + dirs[nextDir][1];
            
            if (!visited.contains(newX + "-" + newY) && robot.move()) {
                dfs(robot, newX, newY, nextDir, visited);
            }
            
            robot.turnRight();
        }
        
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}