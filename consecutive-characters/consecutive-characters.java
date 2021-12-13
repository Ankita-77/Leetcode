class Solution {
    public int maxPower(String s) {
        if(s.length()==0 || s.length()==1) return s.length();
        int max=0;
        
        for(int i=0;i<s.length();){
            int j=i;
            int count=0;
            while(j<s.length() && s.charAt(i)==s.charAt(j)){
                count++;
                j++;
            }
            i=j;
            max=Math.max(max,count);
        }
        return max;
    }
}