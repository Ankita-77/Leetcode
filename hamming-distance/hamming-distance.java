class Solution {
    public int hammingDistance(int x, int y) {
      int f = 1;
      int distance = 0;
      while(x!=0 || y!=0){
          if((x&f) != (y&f)){
              distance++;
          }
          x = x>>1;
          y = y>>1;
      }
        return distance;
    }
}