class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() < 1) return "";
        
        String max = "";
        
        for(int i=0;i<s.length();i++){
            String s1 = checkPalindrome(s,i,i);
            //To check the palindrome of odd length palindromic sub-string
            String s2 = checkPalindrome(s,i,i+1);
            //To check the palindrome of even length palindromic sub-string
            
            if(s1.length() > max.length())  max = s1;  // max of both
            if(s2.length() > max.length())  max = s2;
        }
        
             return max;
    }
        
        
    public String checkPalindrome(String s, int left, int right){
            if(s == null || left > right) return "";
        
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                 //Check for the palindrome string 
                
                left--;   //To trace string in left direction
                right++;  //To trace string in right direction
                
            }
        
            return s.substring(left+1,right);
     }
}