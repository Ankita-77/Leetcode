class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i=0;i<matrix.length;i++){
            int minOfRow = 0;
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] < matrix[i][minOfRow]){
                    minOfRow = j;
                }
            }
            
            boolean flag = true;
            for(int k=0;k<matrix.length;k++){
                if(matrix[k][minOfRow] > matrix[i][minOfRow]){
                    flag = false;
                    break;
                }
            }
            
            if(flag == true){
                ans.add(matrix[i][minOfRow]);
            }
        }
        return ans;
    }
}