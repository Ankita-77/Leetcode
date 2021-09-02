class Solution {
    public int longestValidParentheses(String S) {
         int n = S.length();
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int result = 0;
        
        for (int i = 0; i < n; i++)
        {
       
            if (S.charAt(i) == '(')
                st.push(i);
            else{
                if(!st.empty())
                    st.pop();

                if (!st.empty())
                    result= Math.max(result,i - st.peek());
                else
                    st.push(i);
            }
        }
 
        return result;
    }
}