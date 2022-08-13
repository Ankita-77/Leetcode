class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int cnt = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i=nums.length-1; i>=0; i--){
            set.add(nums[i]);
            
            if(set.contains(nums[i]+diff) && set.contains(nums[i]+diff*2)){
                cnt++;
            }
        }
        
        return cnt;
    }
}