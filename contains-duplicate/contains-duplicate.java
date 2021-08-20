class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // hash table will help to identify whether an element has been previously              encountered in the array.

        Set<Integer> duplicate = new HashSet<Integer>();
        
        for(int num : nums){
            if(duplicate.contains(num))
                return true;
            else
                duplicate.add(num);
        }
               
          return false;
    }
}


//Time complexity: O(N), memory: O(N)