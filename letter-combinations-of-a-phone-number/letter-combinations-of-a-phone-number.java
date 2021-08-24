public class Solution {
        public static List<String> letterCombinations(String digits) {
            String digitLetter[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            
            List<String> result = new ArrayList<String>();
            
            if(digits.length() == 0){
                return result;
            }
            
            result.add("");
            
            for(int i=0;i<digits.length();i++){
                result = Combine(digitLetter[digits.charAt(i)-'0'], result);
                // pass abc and result string
            }
            return result;
    }
    
    public static List<String> Combine(String digitString, List<String> leftString){
        
        List<String> result = new ArrayList<String>();
        
        for(int i=0; i<digitString.length(); i++){
            for(String x : leftString){
                result.add(x + digitString.charAt(i));
            }
        }
        
        return result;
    }
}


// O(2^n) time complixity
// O(n) space complixity
// n is the length of input.