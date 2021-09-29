class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        
        if(numbers == null || numbers.length < 2) return indices;
        int start = 0, end = numbers.length-1;
        
        while(start < end){
        int value = numbers[start] + numbers[end];
        
        if(value == target){
            indices[0] = start + 1;
            indices[1] = end + 1;
            break;
        }else if(value > target){
            end--;
        }else{
            start++;
        }
     }
        return indices;
  }
}

// The binary search is executed n times because its in a for loop, therefore O(nlogn)