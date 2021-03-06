// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // int ans[] = new int[V];
        int indegree[] = new int[V];
        
        // find indegree
        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        // int idx = 0
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            // ans[idx++] = node;
            cnt++;
             
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(cnt == V) return false;
        return true;
        
        // dfs 
        // int vis[] = new int[V];
        // int dfsVis[] = new int[V];
        // for(int i=0; i<V; i++){
        //     if(vis[i] == 0){
        //         if(checkCycle(i, vis, dfsVis, adj) == true){
        //             return true;
        //         }
        //     }
        // }
        // return false;
    }
    
    // using dfs
    // public boolean checkCycle(int node, int[] vis, int[] dfsVis, ArrayList<ArrayList<Integer>> adj){
    //     vis[node] = 1;
    //     dfsVis[node] = 1;
        
    //     for(int it : adj.get(node)){
    //         if(vis[it] == 0){
    //             if(checkCycle(it, vis, dfsVis, adj) == true){
    //                 return true;
    //             }
    //         }else if(dfsVis[it] == 1){
    //             return true;
    //         }
    //     }
    //     dfsVis[node] = 0;
    //     return false;
    // }
}