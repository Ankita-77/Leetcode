class Solution {
    public int compress(char[] chars) {
        int index = 0, indexAns = 0;
        while(index < chars.length){
            char currChar = chars[index];
            int count = 0;
            while(index < chars.length && currChar == chars[index]){
                index++;
                count++;
            }
            chars[indexAns++] = currChar;
            if(count != 1){
               for(char c : Integer.toString(count).toCharArray()) 
                    chars[indexAns++] = c;
            }
        }
        return indexAns;
    }
}