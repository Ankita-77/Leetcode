class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // hashSet will help to identify whether an element has been previously encountered in the array.

        HashSet<Integer> duplicate = new HashSet<>();
        
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
