class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, Comparator.comparingInt(x -> (x[0] - x[1])));
        int n = costs.length / 2;
        int ans = 0;
        for(int i = 0; i < n; i++){
           ans += costs[i][0] + costs[i + n][1]; 
        }
        return ans;
    }
}