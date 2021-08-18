class Solution {
    public String intToRoman(int num) {
        if (num < 1 || num > 3999) return "";
        
       int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
       String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
       StringBuilder sb = new StringBuilder();
        
       int i = 0;
        
       //iterate until the number becomes zero, NO NEED to go until the last element in roman array
       while(num > 0){
            while(num >= values[i]) {
                num -= values[i];
                sb.append(strs[i]);
             }
           i++;
        }
        
    return sb.toString();
        
 }
    
}


// as for 24 = XXIV
// for 324 = CCCXXIV
// for 2314 = MMCCCIV
// find digit and map it through the string.
