class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num,0)+1);
        }
        
        int n = nums.length;
        n = n/2;
        int ans = 0;
        
        for(Map.Entry<Integer, Integer> set : map.entrySet()){
            if(set.getValue() > n){
                ans = set.getKey();
            }
        }
        
        return ans;
    }
}