class Solution {
    public void solve(int start, int target, int k, List<List<Integer>> ans,         List<Integer> ds){     
        if(ds.size() == k && target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = start; i <= 9; i++) {
            ds.add(i);
            solve(i+1, target-i, k, ans, ds);
            ds.remove(ds.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, n, k, ans, new ArrayList<Integer>());
        return ans;
    }
}