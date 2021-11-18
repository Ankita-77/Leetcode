class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        int n = nums.length;
        // Negate each number while traversing
        for(int i=0; i<n; i++){
            int curr = Math.abs(nums[i]) - 1;
            nums[curr] = nums[curr] > 0 ? -nums[curr] : nums[curr];
        }
        
        // Run again and find the index that is not negated.
        for(int i=0; i<n; i++){
            if(nums[i] > 0){
                res.add(i+1);
            }
        }
        
        return res;
    }
}