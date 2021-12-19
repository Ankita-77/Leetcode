class Solution {
    private int pos=0;
    public String decodeString(String s) {
        int n=s.length(), repeat=0;
        StringBuffer buf = new StringBuffer();
        while(pos<n){
            char c=s.charAt(pos);
            if(c>='a' && c<='z'){
                buf.append(c);
            }
            else if(c>='0'&&c<='9'){
                repeat=repeat*10+(c-'0');
            }
            else if(c=='['){
                pos++;
                String str=decodeString(s);
                for(int i=0;i<repeat;i++){
                    buf.append(str);
                    
                }
               repeat=0; 
            }
            else if(c==']'){
                break;
            }
           pos++; 
        }
        return buf.toString();
    }
}