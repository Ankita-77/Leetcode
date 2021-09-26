class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0, end = n-1;
        
        if(nums[0]<nums[n-1])
        return nums[0];
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            
// for min element in arr that min element should be less than the previous and next element of the array.
            
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){
                return nums[mid];
            }
            
// if first ele is less than mid means it is sorted, min ele will be in right side. if last ele is less then it min ele will be in left side.
            
            if(nums[0] <= nums[mid]){
                start = mid + 1;
            }else if(nums[mid] <= nums[n-1]){
                end = mid - 1;
            }
        }
        
        return -1;
    }
}