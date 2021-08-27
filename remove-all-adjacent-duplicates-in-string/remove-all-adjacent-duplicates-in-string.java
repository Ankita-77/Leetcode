class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()){    
            if(st.size() > 0 && st.peek() == ch){
                st.pop();  // if character equal means they both are adjacent so pop
            }else{
                st.push(ch);    // else push
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(char ch : st) sb.append(ch);    
        
        return sb.toString();
    }
}