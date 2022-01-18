class Solution {
    // for solution 1
//     public void solve(int[] nums, List<List<Integer>> ans, boolean[] freq, List<Integer> ds){
//         if(ds.size() == nums.length){
//             ans.add(new ArrayList<>(ds));
//             return;
//         }
        
//         for(int i=0; i<nums.length; i++){
//             if(!freq[i]){
//                 // mark check on frequency array.
//                 freq[i] = true;
//                 ds.add(nums[i]);
//                 solve(nums, ans, freq, ds);
//                 // uncheck 
//                 freq[i] = false;
//                 ds.remove(ds.size()-1);
//             }
//         }
//     }
    
    // solution 2
    public void solve(int idx, int[] nums, List<List<Integer>> ans){
        if(idx == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int i=0; i<nums.length; i++){
                ds.add(nums[i]);
            }
            ans.add(ds);
            return;
        }
        
        for(int i=idx; i<nums.length; i++){
            swap(i, idx, nums);
            solve(idx+1, nums, ans);
            swap(i, idx, nums);
        }
    }
    
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    public List<List<Integer>> permute(int[] nums) {
        // for solution 1
        // List<List<Integer>>  ans = new ArrayList<>();
        // boolean freq[] = new boolean[nums.length];
        // solve(nums, ans, freq, new ArrayList<>());
        // return ans;
        
           List<List<Integer>>  ans = new ArrayList<>();
           solve(0, nums, ans);
           return ans;
    }
}

// solution 1:-
// Time = n! * n  (n! for n! permutation, n for looping everytime 0 to n)
// space = O(n) + O(n) (n for ds, n for map array)

// solution 2:-
// Time = n! * n (same as last)
// space = without auxiliary not extra space