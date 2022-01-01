class Solution {
    
public int maxCoins(int[] arr) {
    
        return burstBalloons(arr, 0, arr.length - 1, new Integer[arr.length]                 [arr.length]);
    
    }
    
private int burstBalloons(int[] arr, int l, int r, Integer[][] dp) {
        if(l < 0 || r < 0 || l >= arr.length || r >= arr.length) return 0;
        
        if(dp[l][r] != null) return dp[l][r];
        int max = 0;
        int prev = l - 1 >= 0 ? arr[l - 1] : 1;
        int next = r + 1 < arr.length ? arr[r + 1] : 1;
        
        for(int i = l; i <= r; i++) {
            max = Math.max(max, burstBalloons(arr, l, i - 1, dp) + (prev * arr[i] *               next) + burstBalloons(arr, i + 1, r, dp));
        }
        
        return dp[l][r] = max;
    }
}