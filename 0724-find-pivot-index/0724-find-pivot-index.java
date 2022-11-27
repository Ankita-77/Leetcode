class Solution {
    public int pivotIndex(int[] nums) {
        int pivot = -1;
        if(nums.length == 1){
            return 0;
        }
        
        if(nums.length == 2){
            if(nums[1] == 0){
                return 0;
            }else if(nums[0] == 0){
                return 1;
            }else{
                return -1;
            }
        }
        
        if(nums.length == 3){
            if(nums[1] + nums[2] == 0){
                return 0;
            }else if(nums[0] + nums[1] == 0){
                return 2;
            }else{
                return -1;
            }
        }
        
       int left[] = new int[nums.length];
       int right[] = new int[nums.length];
        
        left[0] = nums[0];
        for(int i=1; i<nums.length; i++){
            left[i] = nums[i] + left[i-1];
        }
    
        right[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            right[i] = nums[i] + right[i+1];
        }
        
        for(int i=0; i<nums.length; i++){
            if(left[i] == right[i]){
                return i;
            }
        }
        
        return -1;
    }
}