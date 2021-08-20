class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = nums[0]; 
        
        for(int i=0;i<nums.length;i++){    
            sum = sum + nums[i];  
            
 // if sum is less than 0 then sum=0 and if sum > maxi then maxi = sum.         
            if(sum > maxi) maxi = sum;
            if(sum < 0) sum = 0;;
        }
        return maxi;
    }
}


// kadane's algorithm
// Time Complexity = O(N) 
// Space Complexity = O(1);