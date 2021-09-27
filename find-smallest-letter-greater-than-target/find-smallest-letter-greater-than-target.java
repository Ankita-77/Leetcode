class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length-1;
        
// return the first element if there is no character greater than target in the array
        if(target >= letters[letters.length-1]){
            return letters[0];
        }
        
        while(start <= end){
            
            int mid = start + (end-start)/2;
            
            if(target >= letters[mid]){
                start = mid+1;
            }
            else if(target < letters[mid]){
                end = mid-1;
            }
        }
        
// after the loop breaks; start element will be smallest element greater than target
        return letters[start];
    }
}