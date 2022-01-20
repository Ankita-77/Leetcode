class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int MAX=Integer.MIN_VALUE;
        for(int a: piles){
            MAX=Math.max(MAX,a);
        }
        int lo=1,hi=MAX;
        int rv=1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            boolean canicompleteinmid=check(piles,mid,h);
            if(canicompleteinmid){
                rv=mid;
                hi=mid-1;
            }else{
                lo=mid+1;
            }
        }
        return rv;
    }
    
    public boolean check(int[] piles, int rate,int h){
        int time=0;
        for(int i=0;i<piles.length;i++){
            time+=Math.ceil((double)piles[i]/rate);
        }
        if(time<=h){
            return true;
        }
        return false;
    }
}