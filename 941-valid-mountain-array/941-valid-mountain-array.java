class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length < 3){
            return false;
        }
        int val = findMax(arr);
        
        if(val == arr.length-1){
            return false;
        }
        
        if(val == 0){
            return false;
        }
        
        for(int i=val; i>=1; i--){
            if(!(arr[i] > arr[i-1])){
                return false;
            }
        }
        
        for(int i=val; i<arr.length-1; i++){
            if(!(arr[i] > arr[i+1])){
                return false;
            }
        }
        return true;
    }
    
    public int findMax(int[] arr){
        int max = arr[0];
        int point = 0;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                point = i;
            }
        }
        
        return point;
    }
}