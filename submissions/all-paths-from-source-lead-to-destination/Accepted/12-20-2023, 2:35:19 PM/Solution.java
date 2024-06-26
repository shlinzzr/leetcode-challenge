// https://leetcode.com/problems/all-paths-from-source-lead-to-destination

class Solution {
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();
        
        for(int i=0; i< edges.length; i++){
            int src = edges[i][0];
            int tar = edges[i][1];

            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(tar);   
        }
        
        boolean result = dfs(graph, visited, source, destination);
        
        return result;

    }
    
    
    public boolean dfs(Map<Integer, List<Integer>> graph,  Map<Integer, Boolean> visited, int start, int destination ){
        
        if(visited.containsKey(start))
            return visited.get(start);
    
        // to check the below condition 
        // node with no outgoing edges should be equal to destination
        
        if(start == destination && graph.get(destination) ==null)
            return true;
        
         if(start == destination && graph.get(destination).size() > 0)
            return false;
        
        
        // if any node has no outgoing edges and it is not destination then return false'
         if(start != destination && graph.get(start) ==null)
            return false;
        
       
        
         visited.put(start, false);
        
        for(int neighbour:  graph.getOrDefault(start, new ArrayList<>())){
            
            boolean result = dfs(graph, visited, neighbour, destination);
            
            if(!result)
                return false;
        }
        
        visited.put(start, true);
        
        return true;
        
    }
}