class Solution {
    public void moveZeroes(int[] arr) {
        int n = arr.length;
        int x = 0;
        for(int i=0; i<n; i++){
            if(arr[i] != 0){
                arr[x++] = arr[i];
            }
        }
        
        for(int i=x; i<n; i++){
            arr[i] = 0;
        }
    }
}