class Solution {
    public boolean rotateString(String s, String goal) {
        return (s.length() == goal.length() && (s+s).contains(goal));
    }
}


// “abcdeabcde” (A + A)
// “cdeab” (B)
//  B is found in (A + A), so B is a rotated string of A.