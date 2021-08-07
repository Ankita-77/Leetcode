class Solution {
    public int[][] generateMatrix(int n) {
        int total = n*n;
        int ans[][] = new int[n][n];
        int count = 1;
        int minr = 0, minc = 0, maxr = ans.length-1, maxc = ans[0].length-1;
        
        while(count <= total){
            
            // top wall
            for(int i=minr, j=minc; j<=maxc && count <= total; j++){
                ans[i][j] = count;
                count++;
            }
            minr++;
            
            //right wall
            for(int i=minr, j=maxc; i<=maxr && count <= total; i++){
                ans[i][j] = count;
                count++;
            }
            maxc--;
            
            //bottom wall
            for(int i=maxr, j=maxc; j>=minc && count <= total; j--){
                ans[i][j] = count;
                count++;
            }
            maxr--;
            
            //left wall
            for(int i=maxr, j=minc; i>=minr && count <= total; i--){
                ans[i][j] = count;
                count++;
            }
            minc++;
        }
        
       return ans;
    }
}