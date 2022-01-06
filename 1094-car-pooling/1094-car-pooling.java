class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int lastDest = Integer.MIN_VALUE;
        
        for(int i=0;i<trips.length;i++){
            lastDest = Math.max(lastDest, trips[i][2]);
        }
        int[] arr = new int[lastDest+1];
        System.out.println(lastDest);
        
        
        for(int i=0;i<trips.length;i++){
            arr[trips[i][1]] += trips[i][0];
            arr[trips[i][2]] += -trips[i][0];
        }
        int sum =0;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
            sum += arr[i];
            if(sum > capacity){
                return false;
            }
        }
        return true;
    }
}