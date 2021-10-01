class Solution {
    public int search(int[] nums, int target) {
        int index = findMin(nums);
        
        int a1 = binarySearch(nums, 0, index-1, target);
        int a2 = binarySearch(nums, index, nums.length-1, target);
        
        if(a1 == -1 && a2 == -1) return -1;
        return a1 == -1 ? a2 : a1;
    }
    
    public int binarySearch(int[] nums, int start, int end, int target){
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(nums[mid] == target){
                return mid;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    
    public int findMin(int[] nums){
        int n = nums.length;
        int start = 0, end = n-1;
        
        if(nums[0]<nums[n-1])
        return 0;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
     
            if(nums[mid] <= nums[prev] && nums[mid] <= nums[next]){
                return mid;
            }
  
            if(nums[0] <= nums[mid]){
                start = mid + 1;
            }else if(nums[mid] <= nums[n-1]){
                end = mid - 1;
            }
        }
        return -1;
    }
}