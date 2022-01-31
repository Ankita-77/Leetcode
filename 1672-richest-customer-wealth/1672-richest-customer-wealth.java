class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for(int i=0; i<accounts.length; i++){
            int ans = 0;
            for(int j=0; j<accounts[0].length; j++){
                ans = ans + accounts[i][j];
            }
            if(ans > max)
                max = ans;
        }
        return max;
    }
}