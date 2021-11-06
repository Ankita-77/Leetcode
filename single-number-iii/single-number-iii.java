class Solution {
    public int[] singleNumber(int[] nums) {
        int temp = 0;
        for (int n : nums) {
            temp ^= n;
        }
        int mask = -temp & temp;

        int single1 = 0, single2 = 0;
        for (int num : nums) {
            if ((num & mask) == 0) {
                single1 ^= num;
            } else {
                single2 ^= num;
            }
        }
        return new int[] {single1, single2};
    }
}