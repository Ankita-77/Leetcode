class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>() ;
        for(int[] row : mat){
            int count=0 ;
            for(int elem : row){
                if(elem==1){
                    count++ ;
                }
            }
            list.add(count) ;
        }
        int[] ans= new int[k] ; 
        
        for(int i=0 ; i<k ;i++){
            int index = list.indexOf(Collections.min(list)) ;
            ans[i] = index ;
            list.set(index,99); 
        }
        return ans;
    }
}