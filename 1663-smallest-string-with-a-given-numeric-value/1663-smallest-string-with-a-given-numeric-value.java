class Solution {
    public String getSmallestString(int n, int k) {
         StringBuilder sb = new StringBuilder();
         int res = k - n;
         for(int i = 0; i < n; i++){
             if(res/25>=1){
                 sb.append('z');
                 res-=25;
             }else if(res != 0){
                 sb.append((char)(res + 'a'));
                 res = 0;
             }else{
                 sb.append('a');
             }
         } 
         return sb.reverse().toString();
    }
}