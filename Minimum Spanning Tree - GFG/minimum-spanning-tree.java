// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    
    static class Edge implements Comparable<Edge>{
        int vtx,wt;
        Edge(int vtx, int wt){
            this.vtx = vtx;
            this.wt = wt;
        }
        public int compareTo(Edge e){
            return this.wt-e.wt;
        }
    }
    
    static int dist(ArrayList<ArrayList<Edge>> adj, int u, int v){
        for(Edge e: adj.get(u)) if(e.vtx==v) return e.wt;
        return 0;
    }
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int v, ArrayList<ArrayList<ArrayList<Integer>>> alist){
        // Add your code here
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for(int i=0;i<v;i++) adj.add(new ArrayList<>());
        for(int i=0;i<v;i++){
            for(ArrayList<Integer> al: alist.get(i)) adj.get(i).add(new Edge(al.get(0),al.get(1)));
        }
        int key[] = new int[v];
        Arrays.fill(key,Integer.MAX_VALUE);
        int par[] = new int[v];
        Arrays.fill(par,-1);
        boolean mst[] = new boolean[v];
        key[0] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(0,0));
        while(!pq.isEmpty()){
            Edge curr = pq.poll();
            mst[curr.vtx] = true;
            for(Edge e: adj.get(curr.vtx)){
                if(!mst[e.vtx] && e.wt<key[e.vtx]){
                    key[e.vtx] = e.wt;
                    par[e.vtx] = curr.vtx;
                    pq.offer(new Edge(e.vtx,e.wt));
                }
            }
        }
        int sum = 0;
        for(int i=0;i<v;i++){
            if(par[i]!=-1) sum += dist(adj,i,par[i]);
        }
        return sum;
    }
}