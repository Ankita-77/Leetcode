class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(res);
                res = 0;
            } else {
                res = Math.max(1, res * 2);
                res += st.pop();
            }
        }
        return res;
    }
}