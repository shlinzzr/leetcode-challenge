// https://leetcode.com/problems/process-tasks-using-servers

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        int[] ans = new int[m];

        PriorityQueue<int[]> freeServer = new PriorityQueue<>( //idx, weight[idx]
            (a,b)-> a[1]==b[1] ? a[0]-b[0] : a[1]-b[1]
        );

        PriorityQueue<int[]> running = new PriorityQueue<>( //idx, weight[idx], finishTime
              (a,b)-> a[2]==b[2] ? a[1]==b[1] ? a[0]-b[0] : a[1]-b[1] : a[2]-b[2]
        );

        for(int i=0; i<n; i++){
            freeServer.offer(new int[]{i, servers[i]});
        }

        Queue<int[]> q= new LinkedList<>();
        for(int j=0; j<m || !q.isEmpty(); j++){
            int t = tasks[j];

            while(!running.isEmpty() && running.peek()[2]<=j){
                int[] s = running.poll();
                freeServer.offer(new int[]{s[0], s[1]});
            }
            // if(j<m){
            //     q.offer(new int[]{j, tasks[j]});
            // }


            if (freeServer.isEmpty()) {
                int[] s = running.poll();
                ans[j] = s[0];
                running.add(new int[]{s[0], s[1], s[2]+t});
            } else {
                int[] s = freeServer.poll();
                ans[j] = s[0];
                running.add(new int[]{s[0], s[1], j+t});
            }

            // while(!q.isEmpty() && !freeServer.isEmpty()){
            //     int[] t = q.poll();
            //     int[] s = freeServer.poll();

            //     ans[t[0]] = s[0];
            //     running.offer(new int[]{s[0], s[1], j+t[1]});
            // }
        }


        return ans;

        

    }
}