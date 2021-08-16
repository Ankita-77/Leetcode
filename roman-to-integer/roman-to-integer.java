class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        
        int result = 0;
        for(int i=0;i<s.length();i++){
            if(i>0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1))){
                result += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i-1));
            }else{
                result += map.get(s.charAt(i));
            }
        }
        
        return result;
    }
}

// let's take no 90 means XC if we add blindly then output will be 110.
// so in this we see if i-1 means X(10) is less than i means C(100) then subtract it 2 times. first for the first wrong addition which gives 110-10 = 100 then second one for the 100-10 = 90.