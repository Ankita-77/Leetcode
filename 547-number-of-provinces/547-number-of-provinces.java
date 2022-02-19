class Solution {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null || isConnected.length == 0) return 0;
        int n = isConnected.length;
        unionFind u = new unionFind(n);
        
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(isConnected[i][j] == 1){
                    u.solve(i, j);
                }
            }
        }
        
        return u.count;
    }
    
    class unionFind{
        int parent[];
        int rank[];
        int count = 0;
        
        public unionFind(int n){
            parent = new int[n];
            rank = new int[n];
            count = n;
            
            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }
        
        public void solve(int u, int v){
            u = findPar(u);
            v = findPar(v);
            
            if(u == v) return;
            if(rank[v] > rank[u]){
                parent[u] = v;
            }else if(rank[u] > rank[v]){
                parent[v] = u;
            }else{
                parent[v] = u;
                rank[u]++;
            }
            count--;
        }
    
        public int findPar(int node){
            if(node == parent[node]){
                return node;
            }
            
            return parent[node] = findPar(parent[node]);
        }
        
        public int count(){
            return count;
        }
    }   
}