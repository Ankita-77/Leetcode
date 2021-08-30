class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        if (matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int[] h = new int[m];
        int maxHistArea = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(matrix[i][j] != '0'){
                    h[j] += 1;
                }else{
                    h[j] = 0;
                }
            }
            
            int currHistArea = MAH(h);
            if(currHistArea > maxHistArea){
                 maxHistArea = currHistArea;
            }
        }
        
         return maxHistArea;
    
    }
    
    // find maximum area of histogram
     public int MAH(int[] hist){
        
        int n = hist.length;
        
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        // find nearest smaller left
        for(int i=0; i<n; i++){
            while(st.size() > 0 &&  hist[i] <= hist[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            
            st.push(i);
        }
        
        
        // find nearest smaller right
        st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(st.size() > 0 &&  hist[i] <= hist[st.peek()]){
                st.pop();
            }
            
            if(st.size() == 0){
                nsr[i] = n;
            }else{
                nsr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        
       int ans[] = new int[n];
       int area = 0;
       for(int i=0; i<n; i++){
            ans[i] = (Math.abs(nsr[i] - nsl[i]) - 1) * hist[i];
            if(area < ans[i]){
                area = ans[i];
            }
       }
       return area;
    }
}