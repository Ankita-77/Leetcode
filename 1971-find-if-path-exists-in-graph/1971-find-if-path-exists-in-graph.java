class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> adjacency_list = new ArrayList<>();        
        for (int i = 0; i < n; i++) {
            adjacency_list.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjacency_list.get(edge[0]).add(edge[1]);
            adjacency_list.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        if(check(visited, adjacency_list, source, destination) == true){
            return true;
        }
                    
            
        return false;
    }
    
    public boolean check(int[] visited, List<List<Integer>> adj, int s, int d){
        if(s == d){
            return true;
        }
        visited[s] = 1;
        for(int it : adj.get(s)){
            // if(it == d){
            //     return true;
            // }
            if(visited[it] == 0){
                if(check(visited, adj, it, d) == true){
                    return true;
                }
            }
        }
        return false;
    }
}