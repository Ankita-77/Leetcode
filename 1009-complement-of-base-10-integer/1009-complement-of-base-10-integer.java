class Solution {
    public int bitwiseComplement(int n) {
        return solution(n);
    }
    
    public static int solution (int num) {
        int bits = Integer.toBinaryString(num).length();
        int maxBound = (int)( Math.pow(2, bits)-1);
        return num ^ maxBound;
    }
}