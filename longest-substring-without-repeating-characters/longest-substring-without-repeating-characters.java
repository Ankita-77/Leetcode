class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0,max=0;
        HashSet<Character> hash_set = new HashSet();
        
          //use a pointer j to see if character j is in the hash set or not, if not,                 add it to the hash set, move j forward and update the max length
        
        while(j<s.length()){
            if(!hash_set.contains(s.charAt(j))){
                hash_set.add(s.charAt(j));
                j++;
                max = Math.max(max,hash_set.size());
            }else{
                hash_set.remove(s.charAt(i));
                i++;
            }
        }
        
         // otherwise, delete from the head by using a pointer i until we can put                    character j to the hash set
        
        return max;
    }
}