class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int a : nums3){
            for(int b : nums4){
                map.put(a+b, map.getOrDefault(a+b, 0) + 1);
            }
        }
        
        for(int a : nums1){
            for(int b : nums2){
                int sum = a+b;
                count += map.getOrDefault(-(sum), 0);
            }
        }
        
        return count;
    }
}