class Solution {
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(target == nums[mid]){
                return mid;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return start;
    }
}

// Start return Because the terminating condition in your loop depends on the low as soon as it gets more than high the loop terminates which means now your value is at the desired place.
// In short- terminating condition decides the return value outside the loop.