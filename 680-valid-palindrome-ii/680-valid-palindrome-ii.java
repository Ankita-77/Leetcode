class Solution {
    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return checkPalindrome(s,i+1,j) || checkPalindrome(s,i,j-1);
            }
            
            // check for the i and j different letter substring.
            
// case 1: delete i letter check from i+1 to j as we can delete only one letter.
       //  if they are not equal return false.
// case 2: delete j letter check from j-1 to i if not equal return false.
            
            i++;
            j--;
        }
        
        return true;
    }
    
    
    public boolean checkPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            
            i++;
            j--;
        }
        
        return true;
    }
}