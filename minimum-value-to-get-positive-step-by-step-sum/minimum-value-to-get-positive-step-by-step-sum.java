class Solution {
    public int minStartValue(int[] nums) {
        int min = 0;
        int prefixSum = 0;
        
        for(int num : nums){
            prefixSum += num;
            min = Math.min(min, prefixSum);
        }
        
        return min < 0 ? Math.abs(min) + 1 : 1;
    }
}