class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(st.size() > 0 && st.peek() == c){ // if find duplicate than remove
                st.pop();
            }else{
                st.push(c);   // else push into stack
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        
        return sb.toString();
    }
}