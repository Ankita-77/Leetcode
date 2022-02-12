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
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static class Node implements Comparator<Node>{
        int v;
        int weight;
        
        public Node(int v, int weight){
            this.v = v;
            this.weight = weight;
        }
        
        public Node(){}
        
        int getV(){
            return v;
        }
        
        int getWeight(){
            return weight;
        }
        
        // priority queue in decreasing format
        @Override
        public int compare(Node n1, Node n2){
            if(n1.weight < n2.weight){
                return -1;
            }
            
            if(n1.weight > n2.weight){
                return 1;
            }
            
            return 0;
        }
    }
    
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int dist[] = new int[V];
        for(int i=0; i<V; i++){
            dist[i] = 1000000000;
        }
        
        dist[S] = 0;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>(V, new Node());
        pq.add(new Node(S, 0));
        
        while(pq.size() > 0){
            Node node = pq.poll();
            
            for(ArrayList<Integer> it : adj.get(node.getV())){
                int n = it.get(0);
                int w = it.get(1);
                if(dist[node.getV()] + w < dist[n]){
                    dist[n] = dist[node.getV()] + w; 
                    pq.add(new Node(n, dist[n]));
                }
            }
        }
        
        return dist;
    }
}

