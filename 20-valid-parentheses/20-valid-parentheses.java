class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(ch == ')' && !st.empty() &&  st.peek() == '('){
                st.pop();
            }else if(ch == ']' && !st.empty() && st.peek() == '['){
                st.pop();
            }else if(ch == '}' && !st.empty() && st.peek() == '{'){
                st.pop();
            }else{
                return false;
            }
        }
        
        
        if(st.size() == 0){
            return true;
        }else{
            return false;
        }
    }
}