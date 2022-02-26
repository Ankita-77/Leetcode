class Solution {
    static int INF= 1000;
    public int shortestPathLength(int[][] graph) {
        int n= graph.length;
        if(n<4) return n-1;
        
        boolean[][] seen= new boolean[n][1<<n];
        LinkedList<int[]> q= new LinkedList<>();
        for(int i=0; i<n; i++){
            seen[i][1<<i]= true;
            q.offer(new int[]{i, 1<<i});
        }
        int steps= 0, fullMask= (1<<n)-1;
        while(!q.isEmpty()){
            int k= q.size();
            while(k-->0){
                int[] state= q.poll();
                int i= state[0], mask= state[1];
                for(int j:graph[i]){
                    int jMask= mask|(1<<j);
                    if(jMask==fullMask) return steps+1;
                    if(seen[j][jMask]) continue;
                    seen[j][jMask]= true;
                    q.offer(new int[]{j, jMask});
                }
            }
            steps++;
        }
        return -1;
    }
}