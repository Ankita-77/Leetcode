class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 0, c = 0, i;
        
        for(i=1; i<nums.length; i++){
           if(c!=1 || nums[k]!=nums[i]){
                nums[++k] = nums[i];
               c=0;
           } else {
               c=1;
           }
            if(nums[k-1]==nums[i])
                c=1;
        }
        return k+1;
    }
}