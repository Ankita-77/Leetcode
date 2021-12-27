class Solution {

    public int findComplement(int num) {
       int mask=0;
       int j=0; 
        while(mask<num)
        {
            mask=mask+(int)Math.pow(2,j++);
        }

        return mask^num;
    }
}