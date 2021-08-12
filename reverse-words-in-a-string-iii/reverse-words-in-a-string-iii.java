class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();  
        String[] parts = s.split(" ");   //split string by space
        for(String str : parts){
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();   // reverse string
            res.append(sb.toString());   // append into result stringbuilder
            res.append(" ");  // add space
        }
        return res.toString().trim();   // trim eliminates leading and trailing spaces.
    }
}