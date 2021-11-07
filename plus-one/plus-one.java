class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            
            digits[i] = 0;     // case like 1,2,3,9,9 -> 1,2,4,0,0
        }
        
        int new_num[] = new int[n+1];
        new_num[0] = 1;
        return new_num;
    }
}