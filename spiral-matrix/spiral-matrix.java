class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        int minr=0, maxr=matrix.length-1, minc=0, maxc=matrix[0].length-1;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int total = n*m;
        int count = 0;
        
        while(count < total){
            //top wall
            for(int i=minr,j=minc;j<=maxc && count < total;j++){
                result.add(matrix[i][j]);
                count++;
            }
            minr++;
            
            //right wall
            for(int i=minr,j=maxc;i<=maxr && count < total;i++){
                result.add(matrix[i][j]);
                count++;
            }
            maxc--;
            
            //bottom wall
            for(int i=maxr,j=maxc;j>=minc && count < total;j--){
                result.add(matrix[i][j]);
                count++;
            }
            maxr--;
            
            //right wall
            for(int i=maxr,j=minc;i>=minr && count < total;i--){
                result.add(matrix[i][j]);
                count++;
            }
            minc++;
        }
        
        return result;
        
    }
}