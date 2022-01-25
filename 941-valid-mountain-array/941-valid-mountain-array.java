class Solution {
    public boolean validMountainArray(int[] arr) {
        
        if(arr.length < 3) return false;
        int n = arr.length;
        int i = 0;
        int j = n-1;
        
        while(i+1 < n && arr[i] < arr[i+1]) i++;
        while(j > 0 && arr[j] < arr[j-1]) j--;
        
        if(i > 0 && i == j && j < n-1)
            return true;
        else
            return false;
    }     
        
//         if(arr.length < 3){
//             return false;
//         }
//         int val = findMax(arr);
        
//         if(val == arr.length-1){
//             return false;
//         }
        
//         if(val == 0){
//             return false;
//         }
        
//         for(int i=val; i>=1; i--){
//             if(!(arr[i] > arr[i-1])){
//                 return false;
//             }
//         }
        
//         for(int i=val; i<arr.length-1; i++){
//             if(!(arr[i] > arr[i+1])){
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     public int findMax(int[] arr){
//         int max = arr[0];
//         int point = 0;
//         for(int i=1; i<arr.length; i++){
//             if(arr[i] > max){
//                 max = arr[i];
//                 point = i;
//             }
//         }
        
//         return point;
//     }
}