class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix = strs[0];   
        
        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){   
                //It returns the index position for the given substring
                prefix = prefix.substring(0,prefix.length()-1);  
                // dec length by 1 everytime if strs[i] does not match prefix
            }
        }
        return prefix;
    }
}