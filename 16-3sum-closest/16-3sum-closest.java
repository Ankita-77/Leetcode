class Solution {
    // Time Complexity - N^2 Space complexity - 1
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int res = nums[0]+nums[1]+nums[n-1];        
        Arrays.sort(nums);        
        for(int i=0; i<n-2; i++){
            int start = i+1, end = n-1;
            while(start < end){
                int sum = nums[i]+nums[start]+nums[end];
                if(Math.abs(target-sum) < Math.abs(target-res)){
                    res = sum;
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return res;
    }
}