class Solution {
    public int missingNumber(int[] nums) {
        int res = nums.length;
        int i = 0;
        for(int num : nums){
            res ^= num;
            res ^= i;
            i++;
        }
        
        return res;
    }
}