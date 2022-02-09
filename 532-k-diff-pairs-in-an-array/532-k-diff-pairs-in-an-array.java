class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = 0;
        
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int it : map.keySet()){
            if(k == 0){
                if(map.get(it) >= 2){
                    c++;
                }
            }else{
                if(map.containsKey(it + k)){
                    c++;
                }
            }
        }
        
        return c;
    }
}