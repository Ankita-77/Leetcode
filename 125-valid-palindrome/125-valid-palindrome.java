class Solution {
    public boolean isPalindrome(String s) {
        if(s == " ") return true;
        if(s.length() == 1) return true;
        s = s.toLowerCase();
        String ans = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if((ch >= 97 && ch <= 122) || (ch >= 48 && ch <= 57)){
                ans += ch;
            }
        }
        return checkPal(ans);
    }
    
    public boolean checkPal(String s){
        int i = 0;
        int j = s.length()-1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}