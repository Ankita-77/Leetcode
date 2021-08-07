class Solution {
    public String restoreString(String s, int[] indices) {
        char[] charArray = new char[s.length()];
        for(int i=0;i<indices.length;i++){
            int pos = indices[i];
            charArray[pos] = s.charAt(i);
        }
        return String.valueOf(charArray);
    }
}