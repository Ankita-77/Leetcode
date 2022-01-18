class Solution {
    public void solve(int[] nums, List<List<Integer>> ans, boolean[] freq, List<Integer> ds){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i=0; i<nums.length; i++){
            if(!freq[i]){
                // mark check on frequency array.
                freq[i] = true;
                ds.add(nums[i]);
                solve(nums, ans, freq, ds);
                // uncheck 
                freq[i] = false;
                ds.remove(ds.size()-1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  ans = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        solve(nums, ans, freq, new ArrayList<>());
        return ans;
    }
}

// Time = n! *n  (n! for n! permutation, n for looping everytime 0 to n)
// space = O(n) + O(n) (n for ds, n for map array)