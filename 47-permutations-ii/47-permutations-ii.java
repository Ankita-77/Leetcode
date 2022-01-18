class Solution {
    public void solve(int idx, int[] nums, List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        
        Set<Integer> appeared = new HashSet<>();
        for(int i=idx; i<nums.length; i++){
            if (appeared.add(nums[i])) {
                swap(i, idx, nums);
                solve(idx+1, nums, ans);
                swap(i, idx, nums);
            }           
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        solve(0, nums, ans);
        return ans;
    }
}