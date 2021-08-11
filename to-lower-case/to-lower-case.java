class Solution {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder(s); //stringBuilder it is more efficient
        for(int i=0;i<sb.length();i++){
            char ch = sb.charAt(i);  // find every character in String s
            if(ch >= 'A' && ch <= 'Z'){    // if found any uppercase letter
               char lowerCase = (char)('a' + ch - 'A');    
                // change this to lowercase let ex H ascii value is 72 - ascii value of A                    is 65 so add this diff in a.
                sb.setCharAt(i,lowerCase);      // set char at that position
            }
        }
        return sb.toString();
    }
}