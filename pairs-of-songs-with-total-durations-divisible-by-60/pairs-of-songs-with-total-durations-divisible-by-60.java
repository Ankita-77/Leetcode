class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> hm = new HashMap<>();
        int pairs = 0;
        
        for (int i: time) {
            int actual = i % 60;
            int needed = (60 - actual) % 60; 
            
            if (hm.containsKey(needed)) {
                pairs += hm.get(needed);
            }
            hm.put(actual, hm.getOrDefault(actual, 0) + 1);
        }

        return pairs;
    }
}