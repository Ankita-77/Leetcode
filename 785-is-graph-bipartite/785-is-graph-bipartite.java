class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i=0; i<graph.length; i++){
            if(color[i] == -1){
                if(!checkBipartite(i, color, graph)){
                     return false;
                }
            }
        }
        return true;
    }
    
    public boolean checkBipartite(int node, int[] color, int[][] graph){
        if(color[node] == -1) color[node] = 1;
        
        for(int it : graph[node]){
            if(color[it] == -1){
                color[it] = 1 - color[node];  
                if(!checkBipartite(it, color, graph))
                    return false;
            }else if(color[it] == color[node]){
                return false;
            }
        }
        
        return true;
    }
    
    // using bfs
//     public boolean checkBipartite(int node, int[] color, int[][] graph){
//         Queue<Integer> q = new LinkedList<>();
//         color[node] = 1;
//         q.add(node);
        
//         while(!q.isEmpty()){
//             int n = q.remove();
            
//             for(int it : graph[n]){
//                 if(color[it] == -1){
//                     color[it] = 1 - color[n];
//                     q.add(it);
//                 }else if(color[it] == color[n]){
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }
}