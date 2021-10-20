class Solution {
    public String reverseWords(String s) {
        
        String str = "";
        String[] parts = s.split("\\s+");
        
        for(int i=parts.length-1; i>=0; i--){
            str = str + parts[i] + " ";
        }
        
        return str.trim();
    }
}


// "\s" is a regex class for any kind of whitespace (space, tab, newline, etc). Since Java uses "\" as an escape character in strings (e.g. for newlines: "\n"), we need to escape the escape character, So it becomes "\\s". The "+" means one or more of them.