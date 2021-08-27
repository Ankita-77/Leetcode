class Solution {
    public int[] finalPrices(int[] p) {
        
        int n = p.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<>();
        
        ans[n-1] = p[n-1];
        // ans[n-2] = p[n-2];
        st.push(p[n-1]);
        // st.push(p[n-2]);
        
        for(int i=n-2; i>=0 ;i--){
            while(st.size() > 0 && p[i] < st.peek()){
                st.pop();
            }
            
            if(st.size() == 0){
                ans[i] = p[i];
            }else{
                int value = p[i] - st.peek();
                ans[i] = value;
            }
            st.push(p[i]);
        }
        
        return ans;
    }
}