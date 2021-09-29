class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        
        if(days > n){
            return -1;
        }
        
        int start = maxOfWeights(weights, n);
        int end = sumOfWeights(weights, n);
        int res = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(isValid(weights, n, days, mid) == true){
                res = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return res;
    }
    
    // isvalid function
    public boolean isValid(int[] weights, int n, int days, int mid){
        int d = 1;
        int total = 0;
        
        for(int i=0; i<n; i++){
            total = total + weights[i];
            
            if(total > mid){
                d++;
                total = weights[i];
            }
            
            if(d > days){
                return false;
            }
        }
        
        return true;
    }
    
    // find maximum of weights
    public int maxOfWeights(int[] weights, int n){
        int max = weights[0];
        
        for(int i=0; i<n; i++){
            if(weights[i] > max){
                max = weights[i];
            }
        }
        
        return max;
    }
    
    // find total sum of weights
    public int sumOfWeights(int[] weights, int n){
        int sum = 0;
        
        for(int i=0; i<n; i++){
            sum = sum + weights[i];
        }
        
        return sum;
    }
}