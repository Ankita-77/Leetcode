class Solution {
    public void solve(int idx, int[] arr, List<List<Integer>> ans, List<Integer> ds){
        ans.add(new ArrayList<>(ds));
        // add empty list
        for(int i=idx; i<arr.length; i++){
            if(i != idx && arr[i] == arr[i-1]) continue;
// ignore duplicate like if we have already picked up two from the second index, picking up two from the third index will make another duplicate subset of size one.
            
            ds.add(arr[i]);
            solve(i+1, arr, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }
}