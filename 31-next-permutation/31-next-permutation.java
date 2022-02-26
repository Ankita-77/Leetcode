class Solution {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--; 
        
        if(i >= 0) {                           
            int j = nums.length - 1;              
            while(nums[j] <= nums[i]) j--;      
            swap(i, j, nums);                     
        }
        
        reverse(i + 1, nums.length - 1, nums);      
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public void reverse(int i, int j, int[] nums){
        while(i < j){
            swap(i, j, nums);
            i++;
            j--;
        }
    }
}