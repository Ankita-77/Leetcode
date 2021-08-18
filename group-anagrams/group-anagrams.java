class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        
//Two strings are anagrams if and only if their character counts are the same.
        
        Map<String, List> ans = new HashMap<String, List>();
        
        int[] count = new int[26];
        
         //transform each string s into a character count, count, consisting of 26 non-negative integers representing the number of a's, b's,c's, etc. 
        
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}