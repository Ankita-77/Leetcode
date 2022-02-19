class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int it : nums){
            set.add(it);
        }
        
        for(int num : nums){
            if(!set.contains(num-1)){
                int curr = num;
                int count = 1;
                
                while(set.contains(curr+1)){
                    curr += 1;
                    count += 1;
                }
                
                ans = Math.max(ans, count);
            }
        }
        
        return ans;
    }
}