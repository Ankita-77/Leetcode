class Solution {
    public boolean winnerSquareGame(int n) {
        int[] sq = new int[316];
        int sqCount = 0;
        for (int i = 1; i * i <= n; i++) sq[sqCount++] = i * i;
        boolean[] dp = new boolean[n+1];
        for (int i = 1; i <= n; i++)
            for (int j = 0; j < sqCount && sq[j] <= i; j++)
                if (!dp[i - sq[j]]) {
                    dp[i] = true;
                    break;
                }
        
        return dp[n];
    }
}