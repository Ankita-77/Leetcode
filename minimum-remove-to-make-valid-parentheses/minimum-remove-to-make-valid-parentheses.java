class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int open = 0;
        
        for(char c : s.toCharArray()){
            if(c == '('){
                open++;   
            }else if(c == ')'){
                if(open == 0) continue; 
                // as we find '(' open will inc by 1
                // if open = 0 means there is not opening parentheses which is invalid                      so continue.
                open--;
            }
            
            sb.append(c);
        }
        
        // if we have statement like lee(t(c)o)de)(((
        // last fourth remove by above method as open=0 but for last three parentheses
        // open is inc by 1 everytime so open = 3 we have to remove these parentheses.
        
        if(open == 0) return sb.toString();   
        // as open 0 means everything is sortout so simply return the string
        
        StringBuilder result = new StringBuilder();
        for(int i=sb.length()-1; i>=0; i--){  // start from last for 3 parentheses
            if(sb.charAt(i) == '(' && open-- > 0) continue;   
            // if we found '(' and open is greater than 0 so simply continue else append
            result.append(sb.charAt(i));
        }
        
        return result.reverse().toString();
    }
}


// O(N) solution