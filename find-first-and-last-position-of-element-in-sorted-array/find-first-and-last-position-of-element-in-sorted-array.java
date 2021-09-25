class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        
        // for first position of element
        int start = 0;
        int end = nums.length-1;
        int res = -1;
    
        while(start <= end){
            int mid = start + (end-start) / 2;
            
            if(target == nums[mid]){
                res = mid;
                end = mid - 1; // lets see if there one more on the left
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        ans[0] = res;
        
        // for last position of element
        int start1 = 0;
        int end1 = nums.length-1;
        int res1 = -1;
        
        while(start1 <= end1){
            int mid = start1 + (end1-start1) / 2;
            
            if(target == nums[mid]){
                res1 = mid;
                start1 = mid + 1;
                // lets see if there one more on the right
            }else if(target < nums[mid]){
                end1 = mid - 1;
            }else{
                start1 = mid + 1;
            }
        }
        
        ans[1] = res1;
        
        return ans;
    }
}