class Solution {
    public boolean isPowerOfThree(int n) {
        
        // 27 -->  27/3 = 9(rem=0)  --> 9/3 = 3(rem=0) --> 3/3 = 1(rem=0)
        // 10 --> 10/3 = 3 (rem = 1) so return false
        
        while(n>=3){
            if(n%3 != 0) return false;
            n = n/3;
        }
        return n == 1;
    }
}