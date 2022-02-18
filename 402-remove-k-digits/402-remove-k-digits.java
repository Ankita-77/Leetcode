class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        String ans = "";
        Stack<Character> st = new Stack<>();
        
        for(char c : num.toCharArray()) {
            while(!st.empty() && k>0 && st.peek()>c) {
                st.pop();
                k--;
            }
            
            if(!st.empty() || c != '0')
                st.push(c);
        }
        
        while(!st.empty() && k>0) {
            st.pop();
            k--;
        }
        if(st.empty()) 
            return "0";
        
        while(!st.empty())
            ans += st.pop();
        
        String sb = new StringBuilder(ans).reverse().toString();
        if(sb.charAt(0) == '0')
           sb = sb.substring(1);
        
        return sb;
    }
}