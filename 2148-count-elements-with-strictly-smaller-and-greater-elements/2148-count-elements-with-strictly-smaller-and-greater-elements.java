class Solution {
    public int countElements(int[] nums) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(min > nums[i]) min = nums[i];
            if(max < nums[i]) max = nums[i];
        }
        
        for(int i=0; i<nums.length; i++){
            if(nums[i] > min && nums[i] < max){
                ans++;
            }
        }
        return ans;
        
        // by using sorting O(nlogn) + O(n)
        // no need to do sorting just find min and max O(n)
    }
}