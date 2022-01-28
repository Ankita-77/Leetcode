class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long mini = lower;
        long maxi = lower;
        long s=lower;
        for(int i:differences){
            s+=i;
            mini=Math.min(s,mini);
            maxi=Math.max(s,maxi);
        }
        
        long ans = (upper - lower) - (maxi - mini) + 1;
        if(ans < 0){
            ans = 0;
        }
        
        return (int)ans;
    }
}