class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character,Integer> last_occ = new HashMap<>();
        Stack<Character> stk = new Stack<>();
        Set<Character> visited = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            last_occ.put(s.charAt(i),i);
        }
        
        for(int i=0;i<s.length();i++) {
            if(!visited.contains(s.charAt(i))) {
                while(!stk.isEmpty() && s.charAt(i)<stk.peek() &&                                            last_occ.get(stk.peek())>i) {
                visited.remove(stk.pop());
            }
                stk.push(s.charAt(i));
                visited.add(s.charAt(i));
            }
        }
        
        Iterator<Character> itr = stk.iterator();
        String res = "";
        while(itr.hasNext()) {
            res = res + itr.next();
        }
        return res;

    }
}