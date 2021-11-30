class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix == null || matrix[0].length == 0){
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        int maxHist = Integer.MIN_VALUE;
        
        int h[] = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] != '0'){
                    h[j] += 1;
                }else{
                    h[j] = 0;
                }
            }
            
            int currHist = MAH(h);
            if(currHist > maxHist){
                maxHist = currHist;
            }
        }
        return maxHist;
    }
    
    public int MAH(int[] arr){
        int n = arr.length;
        
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        
        Stack<Integer> st = new Stack<>();
        
        // nearest smaller to left
        for(int i=0; i<arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.size() == 0){
                nsl[i] = -1;
            }else{
                nsl[i] = st.peek();
            }
            
            st.push(i);
        }
        
        
        // nearest smaller to right
        st = new Stack<>();
        for(int i=arr.length-1; i>=0; i--){
            while(st.size() > 0 && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            
            if(st.size() == 0){
                nsr[i] =  n;
            }else{
                nsr[i] = st.peek();
            }
            
            st.push(i);
        }
        
        int ans[] = new int[n];
        int area = 0;
        for(int i=0; i<n; i++){
            ans[i] = (Math.abs(nsr[i] - nsl[i] -1)) * arr[i];
            if(area < ans[i]){
                area = ans[i];
            }
        }
        
        return area;
    }
}