class Solution {
    public int findJudge(int n, int[][] trust) {
        int val[] = new int[n+1];
        if(trust.length==0 && n==1){
            return 1;
        }
        for(int i=0;i<trust.length;i++){
            val[trust[i][0]]--;
            val[trust[i][1]]++;
        }
        for(int i=1;i<n+1;i++){
            if(val[i]==n-1)
                return i;
        }
        return -1;
    }
}