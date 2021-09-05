class Solution {
    public String removeDuplicates(String s, int k) {
        
         //Storing the string in StringBuffer
        StringBuffer sb = new StringBuffer(s);
    
         //Array to hold the count of character at particular index
        int count[] = new int[sb.length()];
    
        for(int i =0;i<sb.length();i++){
        
        //For first character and when previous character is not equal to current character
        // then start count again for current character
            
                if(i==0 || sb.charAt(i)!=sb.charAt(i-1)){
                    count[i] =1;
                 }else{
                    
        //when character are equal
        //increase the count by 1 of previous count as they are same characters
                    
            count[i] = count[i-1]+1;
            
            //currentCount ==k,time to delete in buffer
                    
            if(count[i]==k){
                sb.delete(i-k+1,i+1);
                //change the i position after deleting
                i = i-k;
            }   
        }
    }
    return sb.toString();
}
}