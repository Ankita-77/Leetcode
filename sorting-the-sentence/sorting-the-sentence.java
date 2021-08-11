class Solution {
    public String sortSentence(String s) {
        String[] str = s.split(" ");
        // String contains only whitespaces,so split the String at them
	    String[] res = new String[str.length]; 
        // this array of string contains rearranged string.
        StringBuilder sb = new StringBuilder();
        // Stringbuilder is more efficient so use this.
         int i = 0;
        
        for(String element : str){
            i = element.charAt(element.length() - 1) -'0'; 
            // find last digit which is i = index of the word in res[]
            res[i-1] = element.substring(0, element.length()-1);
            // substring of each string except the last digit
        }
        
        //append the words from res[] to StringBuilder 
        for (i = 0; i < res.length - 1; i++){
		sb.append(res[i]).append(" ");      // append upto "This is a " 
        }
        
	    sb.append(res[i]);  // append "sentence" 
        
        return sb.toString();
    }
}