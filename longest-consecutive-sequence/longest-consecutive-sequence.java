class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        for(int val : nums){
            map.put(val, true);
        }
      
// If we find out that the previous number is present in the hashmap, then it could not be the starting of the consecutive sequence. Hence we mark that element as "false", otherwise true.
        
        for(int val : nums){
            if(map.containsKey(val - 1)){
                map.put(val, false);
            }
        }
        
// Now, the elements marked as "true" are those elements which are actually at the starting index of a desired consecutive sequence.For every "true" element, we find all its consecutive elements in the hashmap.
        
        int maxLen = 0;
        for(int val : nums){    
            if(map.get(val) == true){
                
            int tempLen = 1;
            int tempStartPoint = val;
                
            while(map.containsKey(tempStartPoint + tempLen)){
                tempLen++;
            }
            
            if(tempLen > maxLen){
                maxLen = tempLen;
            }
         }
       }
        
       return maxLen;
    }
}

            
// For example, for the element "5", the consecutive sequence becomes 5-6. The size of this sequence is 2. This size is stored as "tempLen"
// time = O(n)
// space = O(n)