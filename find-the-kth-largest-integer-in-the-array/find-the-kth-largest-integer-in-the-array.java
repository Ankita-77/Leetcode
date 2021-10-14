import java.math.BigInteger;

class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        String result = "";
        if(nums==null || nums.length==0 || k<=0){
            return result;
        }
        
        PriorityQueue<BigInteger> pq = new PriorityQueue<>();
        
        for(String i : nums){
            BigInteger number = new BigInteger(i);
            if(pq.size()< k ){
                pq.add(number);
            }else {
                if(pq.peek().compareTo(number)<0){
                    pq.remove();
                    pq.add(number);
                }
            }
        }
        
        return pq.remove().toString();
    }
}

// We can convert string to biginteger (Since few strings in few test cases are larger than long data type).