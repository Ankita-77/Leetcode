class Solution {
    public void solve(int idx, int[] arr, int n, int k, List<List<Integer>> ans,         List<Integer> ds){     
        if(ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        if(idx == n){
            return;
        }
        
        ds.add(arr[idx]);
        solve(idx+1, arr, n, k, ans, ds);
        ds.remove(ds.size()-1);
        solve(idx+1, arr, n, k, ans, ds);
    }
    
    public List<List<Integer>> combine(int n, int k) {
        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, arr, n, k, ans, new ArrayList<Integer>());
        return ans;
    }
}