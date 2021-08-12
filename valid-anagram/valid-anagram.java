class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;  
        
         // creates a size 26 int arrays as buckets for each letter in alphabet
        int alphabet[] = new int[26];  
       
        //increase the bucket value with String s
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i) - 'a']++;   
        }
        
         //decrease the bucket value with String t
        for(int i=0;i<t.length();i++){
            alphabet[t.charAt(i) - 'a']--;    
            
//as soon as a discrepancy is found, it will return false and break out of the loops.
            if(alphabet[t.charAt(i) - 'a'] < 0) return false;
           
        }
        
        //So if they are anagrams, all buckets should remain with 
        //initial value which is zero
        
        for(int i : alphabet) if(i!=0) return false;
        return true;
    }
}