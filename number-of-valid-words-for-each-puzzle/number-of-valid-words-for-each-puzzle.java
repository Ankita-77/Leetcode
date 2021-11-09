class Solution {
    private int bitmask(String word) {
        
        int mask = 0;
        for (char letter : word.toCharArray()) {
            mask |= 1 << (letter - 'a');
        }
        return mask;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> wordCount = new HashMap<>(); 
        for (String word : words) {
            int mask = bitmask(word);
            wordCount.put(mask, wordCount.getOrDefault(mask, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (String puzzle : puzzles) {
            int first = 1 << (puzzle.charAt(0) - 'a');
            int count = wordCount.getOrDefault(first, 0);
            int mask = bitmask(puzzle.substring(1));

            
            for (int submask = mask; submask > 0; submask = (submask - 1) & mask) {
                count += wordCount.getOrDefault(submask | first, 0); 
            }
            result.add(count);
        }
        return result;
    }
};