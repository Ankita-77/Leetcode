class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int mxl[] = new int[n];
        int mxr[] = new int[n];
        
        
        // find maximum element in left
        mxl[0] = height[0];
        
        for(int i=1; i<n; i++){
            mxl[i] = Integer.max(mxl[i-1],height[i]);
        }
        
        // find maximum element in right
        mxr[n-1] = height[n-1];
        
        for(int i=n-2; i>=0; i--){
            mxr[i] = Integer.max(mxr[i+1],height[i]);
        }
        
        // find minimum of element at left and element at right
        int water[] = new int[n];
        for(int i=0; i<n; i++){
            water[i] = (Integer.min(mxl[i],mxr[i])) - height[i];
        }
        
        // sum 
        int sum = 0;
        for(int i=0; i<n; i++){
            sum = sum + water[i];
        }
        
        return sum;
    }
}