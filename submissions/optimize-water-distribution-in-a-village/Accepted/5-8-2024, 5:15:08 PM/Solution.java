// https://leetcode.com/problems/optimize-water-distribution-in-a-village

class Solution {
    
    // Kruskal's algo :
    // 把所有pipe 都放到list內, 一個一個把min edge拿出來

    List<int[]> graphEdges; // node_a , node_b, cost
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        graphEdges = new ArrayList<>();
        addEdges(n, wells, pipes);
        return minCostKruskals(n);
    }

     
    private void addEdges(int n, int[] wells, int[][] pipes) {
        for(int i=0;i<n;i++) {
            graphEdges.add(new int[] {0, i+1, wells[i]});
        }
        
        for(int[] pipe: pipes) {
            graphEdges.add(pipe);
        }
    }

    private int minCostKruskals(int n) {
        Collections.sort(graphEdges, (a,b)-> a[2]-b[2]);

        int cost = 0, processedEdges = 0;
        UnionFind uf = new UnionFind(n+1); // 1-idx
        for(int[] e : graphEdges){
            if(uf.union(e[0], e[1])){
                cost += e[2];
                processedEdges++;
                if(processedEdges==n) break;
            }
        }

        return cost;
    }

    
}

class UnionFind {
    int[] parent;
    int[] weight;
    
    UnionFind(int n) {
        parent = new int[n];
        for(int i=0;i<n;i++) 
            parent[i] = i;
        weight = new int[n];
    }
    
    public int find(int x) {
        if(x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);    
        /// same root - no need to merge (since both are part of same tree)
        if(x == y) return false;
        
        /// merge if they have different root
        if(weight[x] <= weight[y]) {
            parent[x] = y;
            weight[y]++;
        } else {
            parent[y] = x;
            weight[x]++;
        }
        return true;
    }
}
    /*
        直接跑prim's 會失敗的case 在於
        n = 5
        wells = [46012,72474,64965,751,33304]
        pipes = [[2,1,6719],[3,2,75312],[5,3,44918]]
        注意這個圖 並沒有全部連通 只有給 1 2 3 5
        這樣在choose完所有edge後 還要檢查每個vertex有沒有井水 
        發現4沒有給井水; 1,2,3,5還要自己判斷 min_well
        每個單獨的component都要給一個min well 很難處理
        sol => 建一個 virtual vertex 0 with edge = well[i]
    */

    // Prim's
    // public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        
    //     Map<Integer, Map<Integer,Integer>> map = new HashMap<>();

    //     PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1])); //idx, cost
    //     // Prim's algo : start from any node, let's start from virtual vertex zero :
    //     // we create the virtual vertex 0 with the cost with wells
    //     // start from vertex zero
    //     // always choosing the min edge from map

    
    //     buildGraph(pipes, map);   // buildGraph from pipes

    //     // create virtual vertex zero
    //     map.put(0, new HashMap<>());
    //     for(int i=0; i<wells.length; i++){
    //         map.get(0).put(i+1, wells[i]); //wells是 1-idx

    //         pq.offer(new int[]{i+1, wells[i]}); // start from 0's adj;
    //     }

    //     Set<Integer> seen = new HashSet<>();
    //     seen.add(0);

    //     int currCost = 0;
    //     while(!pq.isEmpty()){
    //         int size =pq.size();
    //         while(size-->0){

    //             int[] p = pq.poll();
    //             int idx = p[0];
    //             int pipeCost = p[1];

    //             if(seen.contains(idx)) continue;
    //             seen.add(idx);
    //             currCost += pipeCost;

    //             Map<Integer,Integer> adjs = map.getOrDefault(idx, new HashMap<>());
    //             for(int k : adjs.keySet()){
    //                 if(seen.contains(k)) continue;
    //                 pq.offer(new int[]{k, adjs.get(k)});
    //             }
    //         }
    //     }
    //     return currCost;
    // }

//     private void buildGraph(int[][] pipes, Map<Integer, Map<Integer,Integer>> map ){

//         for(int[] p : pipes){
//             int a = p[0];
//             int b = p[1];
//             int c = p[2];

//             map.putIfAbsent(a, new HashMap<>());
//             if(!map.get(a).containsKey(b) || map.get(a).get(b)>c)
//                 map.get(a).put(b, c);

//             map.putIfAbsent(b, new HashMap<>());
//             if(!map.get(b).containsKey(a) || map.get(b).get(a)>c)
//                 map.get(b).put(a, c);
//         }
//     }
// }