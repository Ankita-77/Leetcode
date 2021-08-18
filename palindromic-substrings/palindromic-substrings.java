class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            isPalindrome(s,i,i);
            //To check the palindrome of odd length palindromic sub-string
            isPalindrome(s,i,i+1);
            //To check the palindrome of even length palindromic sub-string
        }
        return count;
    }
    
    public void isPalindrome(String s, int i, int j){
       while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){    
           //Check for the palindrome string 
            count++;    //Increment the count if palindromic substring found
            i--;        //To trace string in left direction
            j++;        //To trace string in right direction
       }
    }
}
