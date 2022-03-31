class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int res = -1;
        
        int start = maxOfArray(nums, n);
        int end = sumOfArray(nums, n);
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(isValid(nums, n, m, mid) == true){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return res;
    }
    
    public boolean isValid(int[] nums, int n, int m , int mid){
        int sum = 0;
        int splitPart = 1;
        for(int i=0; i<n; i++){
            sum = sum + nums[i];
            
            if(sum > mid){
                splitPart++;
                sum = nums[i];
            }
            
            if(splitPart > m){
                return false;
            }
        }
        
        return true;
    }
    
    public int maxOfArray(int[] nums, int n){
        int max = nums[0];
        for(int i=0; i<n; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        return max;
    }
    
    public int sumOfArray(int[] nums, int n){
        int sum = 0;
        for(int i=0; i<nums.length; i++){
            sum = sum + nums[i];
        }
        
        return sum;
    }
}