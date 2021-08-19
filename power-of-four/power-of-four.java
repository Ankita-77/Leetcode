class Solution {
    public boolean isPowerOfFour(int n) {
        
        // 16 -->  16/4 = 4(rem=0)  --> 4/4 = 1(rem=0)
        // 5 --> 5/4 = 1(rem = 1) so return false
        while(n >= 4){
            if(n%4 != 0) return false;
            n = n/4;
        }
        
        return n == 1;
    }
}