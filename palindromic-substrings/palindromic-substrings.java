class Solution {
    int count = 0;
    public int countSubstrings(String s) {
        for(int i=0;i<s.length();i++){
            isPalindrome(s,i,i);
            isPalindrome(s,i,i+1);
        }
        return count;
    }
    
    public void isPalindrome(String s, int i, int j){
        while(i>=0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            count++;
            i--;
            j++;
        }
    }
}
