class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ctr=0,max=0;
for(int i = 0; i<nums.length;++i)
{
if(nums[i]==1){
ctr++;
if(ctr>max){
max = ctr;
}
}
else {
ctr =0;
}
}

    return max;   
    }
}