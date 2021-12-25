class Solution {
    public int calculate(String s) {
       
        Stack<Integer> st=new Stack<>();
        int k=0;
        char operator='+';
        
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                        k=k*10+Integer.parseInt(s.charAt(i)+"");
            }
            
            if (!Character.isDigit(s.charAt(i)) &&                                     !Character.isWhitespace(s.charAt(i))
                || i==s.length()-1){
                   switch(operator){
                       case '+':st.push(k);
                           break;
                       case '-':st.push(-k);
                           break;
                       case '*':st.push(st.pop()*k);
                             break;
                       case '/':st.push(st.pop()/k);
                           break;
                    }
                
                    k=0;
                    operator=s.charAt(i);
                }}
        
            int ans=0;
            while(!st.isEmpty()){
                ans+=st.pop();
            }
            
        return ans;
    }
   
}