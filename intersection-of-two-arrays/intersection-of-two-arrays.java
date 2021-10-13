class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int val : nums1){
            if(map.containsKey(val)){
                int old = map.get(val);
                int now = old + 1;
                map.put(val, now);
            }else{
                map.put(val, 1);
            }
        }
        
        for(int val : nums2){
            if(map.containsKey(val)){
                res.add(val);
                map.remove(val);
            }
        }
        
        int[] arr = new int[res.size()];
        
        for(int i= 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        
        return arr;
    }
}