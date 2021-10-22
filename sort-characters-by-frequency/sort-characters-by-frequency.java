public class Solution {
    public String frequencySort(String s) {
        Map<Character, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, new StringBuilder()).append(c));
        }
        
        PriorityQueue<StringBuilder> queue = new PriorityQueue<>((a, b) -> (b.length() - a.length()));
        queue.addAll(map.values());
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}