class Solution {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j= 0;
        int m = s.length(), n = t.length();
        if(m == 0) return true;
        if(m > n) return false;
        
        while(j < n){
            if( i == m) return true;
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        
        if(i == m) return true;
        return false;
    }
}