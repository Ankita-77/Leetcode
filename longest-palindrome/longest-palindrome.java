class Solution {
    public int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        
        if(!hs.isEmpty()) return 2*count+1;
        return 2*count;
    }
}


// just count the number of same pairs, then this can be used to put in the different direction to consist of palindrome. Then if there exist more chars, we can put one in the middle.