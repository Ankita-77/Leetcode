class Solution {
    public boolean checkIfPangram(String sentence) {
        Set<Character> s = new HashSet<>();
        for(int i=0;i<sentence.length();i++){
            s.add(sentence.charAt(i));  //put all character in a set
        }
        return s.size() == 26;  // return if length = 26
    }
}


// time O(n)
// space O(26)