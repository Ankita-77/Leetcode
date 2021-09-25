/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 0, end = n, ans = -1;
        
        while(start <= end){
            int mid = start + (end - start) / 2;
            
            if(isBadVersion(mid)){
                ans = mid;
                end = mid - 1;  // left side
            }else{
                start = mid + 1;  // right side
            }
        }
        
        return ans;
    }
}

// Version will be like FFFFTTT
// so if isBadVersion -> false then it should be on right side
// if isBadVersion -> true then it should be on left side