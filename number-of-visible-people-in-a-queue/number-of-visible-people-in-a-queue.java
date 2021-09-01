class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!st.empty() && heights[i] >= st.peek()) {
                st.pop();
                ++ans[i];
            }
            if (!st.empty())
                ++ans[i];
            st.push(heights[i]);
        }
        return ans;
    }
}


// Process from right to left, i = [n-1..0]
// while heights[i] >= st.top()  If heights[i] >= st.top() then i_th person will obscure the others shorter (or equal) people on the right side.
// st.pop()  Remove shorter (or equal) people on the right side, because those people can't be seen anymore.
// ans[i] += 1  i_th person can see those short (or equal) people, so increase by one
// if !st.empty():  If stack is not empty then i_th person can see one more person which is taller than himself.
// ans[i] += 1  increase by one
// st.append(heights[i])  add i_th person to our stack
// return ans