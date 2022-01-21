class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int cur = 0;
        int total = 0;
        int pos = 0;
        for (int i = 0; i < n; ++i) {
            total += gas[i] - cost[i];
            cur += gas[i] - cost[i];
            if (cur < 0) {
                pos = i + 1;
                cur = 0;
            }
        }
        return total >= 0 ? pos : -1; 
    }
}
