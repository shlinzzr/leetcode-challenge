// https://leetcode.com/problems/single-threaded-cpu

class Solution {
    public int[] getOrder(int[][] tasks) {

        int len = tasks.length;

        PriorityQueue<int[]> pool= new PriorityQueue<>( // en, proc, idx
            (a,b)-> a[1]!=b[1] ? a[1]-b[1] : a[2]-b[2]
        );

        PriorityQueue<int[]> pq= new PriorityQueue<>( // en, proc, idx
            (a,b) -> a[0]-b[0]
        );

        for(int i=0; i<len; i++){
            pq.offer(new int[]{tasks[i][0], tasks[i][1], i});
        }

        int[] res = new int[len];
        int idx= 0;
        int max = pq.peek()[0];

        System.out.println("max="+pq.peek()[2]);

        while(idx<len){

            // add task to pool from pq;
            while(!pq.isEmpty() && pq.peek()[0]<=max){
                pool.offer(pq.poll());    
            }

            System.out.println(idx + " "+ max);
            System.out.println("pq="+pq);
            System.out.println("pool="+pool);

            int[] p = pool.poll();
            max += p[1];
            res[idx] = p[2];

            idx++;
        }

        return res;



        
    }
}